# tourismPro旅游网站  
<hr/>
<p>在线预览：<a href="http://www.feelcode.cn/" target="blank">旅游网站TourismPro</a></p>
<p>账号：朱利尔，密码：123</p>
<p>管理员账号：admin，密码：123456</p>
<hr/>  

* 这是一个免费、轻量化、简单、易上手的旅游网站项目，系统包括完整的前端Html页面和后台代码，该项目仅适合作为JavaWeb入门或毕业设计使用，不具备实际使用价值，项目中涉及皮尔逊相关系数的相似度算法Java实现和实际应用可查看景点推荐模块。
* 本项目开源免费，如果您看到有人售卖或利用该项目盈利请帮忙举报，谢谢。
* PS：本人承接毕业设计制作，有意请联系我，划至页面底部获取我的联系方式。
* 以下请您仔细阅读：
    这个项目相比于原来[tourism](https://github.com/jwwam/tourism)的设计更加简洁明了，使用体验也更好，底层应用的实现代码也很简单，但是在部署方式上可能需要耗费一定的精力才能跑起来(相比老版本)，其实这对于每一个项目来说都是如此，相信找到这个项目的小伙伴大多是即将毕业的同学，如果您只是想毕业交差然后另谋他路请直接略过此段往下看，或者建议您找淘宝或者我帮你远程部署，花钱买时间永远是最划算的买卖(恰饭时间O(∩_∩)O)，您大可利用多余的时间去做更有意义的事情。但是如果您毕业后从事编程相关的工作，请一定仔细食用这个项目，相信你一定会有所收获。一个系统从设计到实现是一个非常复杂的过程，这个项目算不上牛逼但是带你入门足够了，项目用到的算法也不算牛逼但是面试吹牛也足够了，以上。

# Project description-项目描述 
* 此项目为tourism的重构版本【tourism是3年前做的一个旅游网站毕业设计，采用ssh架构】  
* 因为tourism开发时间久远，现在对这个项目进行了全新升级  
* 本次升级抛弃了原来一些老旧的技术，底层的所有代码全部重写  
* 采用前后端分离架构  
* RESTful API风格接口化、Json形式数据传输    
* 前端页面进行了升级，引用了一些基本的组件，如dataTables.js、bootstrap.js、bootbox.js  
* 前端没有采用主流框架如Vue、React等，使用基本的HTML+CSS+JQ也减轻了上手难度  
* 引入皮尔逊线性相似度推荐算法的Java实现，应用于项目的“景点推荐”栏目   
 
# Project framework-项目架构   
![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200528175153.png)    
* 采用前后端分离，Jquery + SpringBoot2.0    
* 后端语言Java  
* ORM使用SpringDataJPA    
* 数据库使用MySql5.7+Mongodb3   
* 缓存Redis  
* 部署Nginx+Jar  

# Project algorithm-相关算法  
* 皮尔逊相关系数的相似度算法(Pearson)  
* 以下给出其实现公式：  

![相关算法](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/2015021813074.png)   

* 该算法在本系统中实现了基于景点分数近似度的推荐功能，以下给出数据获取方法代码，具体算法实现请查看CFUtils.cosineSimilarity()方法。  
```
    public List<Spots> findRecommendList(String id) {
        //系统中我将景点抽象成了产品，这样便于扩展，如酒店、旅行团均可看作产品评分，统一记录在系统的分数表中
        //如果是查询景点推荐列表，则根据入参景点id查询景点
        List<Score> productScoreList = scoreDao.findByProductId(id);
        //因为相似度比对需要两份数据，首先得到自己查询的景点的分数集合
        double[] ownProductScoreList = new double[productScoreList.size()];
        for (int i = 0; i < productScoreList.size(); i++) {
            ownProductScoreList[i] = Double.parseDouble(productScoreList.get(i).getGrade());
        }
        //然后得到分数表中所有景点的分数集合
        List<Score> productCountInScoreList = scoreDao.findAllGroupByProductId();
        HashMap<String,double[]> ss = new HashMap<String,double[]>();
        //循环所有景点
        for (int i = 0; i < productCountInScoreList.size(); i++) {
            //得到该产品的所有分数
            List<Score> bb = scoreDao.findByProductId(productCountInScoreList.get(i).getProductId());
            double[] otherProductScoreList = new double[bb.size()];
            //循环该产品的所有分数
            for (int j = 0; j < bb.size(); j++) {
                otherProductScoreList[j] = Double.parseDouble(bb.get(j).getGrade());
            }
            //将产品作为key，分数集合作为value存入map
            ss.put(productCountInScoreList.get(i).getProductId(),otherProductScoreList);
        }
        List<Spots> resSpotsList = new ArrayList<>();
        //循环Map依次比对其线性相似度
        ss.forEach((String k, double[] v)->{
            //得到相似度值
            double n = CFUtils.cosineSimilarity(ownProductScoreList,v);
            log.info("id：{},线性相似度：{}",k,n);
            //判断相似度值是否符合自己设定的阈值
            if(n > pearsonCorrelation) {
                //符合相似阈值，放入推荐列表
                resSpotsList.add(spotsDao.findById(k));
            }
        });
        return resSpotsList;
    }
```

# Project view Page-页面预览如下：
注：看不到图片可能需要梯子(maybe u need VPN)  

* 前端首页：  

![前端首页](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511000840.png)   
* 后台列表：  

![后台列表](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511001624.png)   
* 后台数据添加：  

![后台数据添加](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511001710.png)   
 
 * 前台酒店推荐  
 ![前台酒店推荐](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511010248.png)   
  
 * 前台旅游线路  
 ![前台旅游线路](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511020238.png)   


# Run-启动访问(本地部署)  
1.启动Nginx  
* 下载地址：[点击下载](http://nginx.org/download/nginx-1.18.0.zip)  
```
启动命令：nginx.exe  
```
将两个前端页面【tour-front】和【tour】文件包拷贝到Nginx根目录下，修改./conf/nginx.conf配置文件，替换原有的server配置如下：  
```
    server {
        listen       80;
        server_name  localhost;

        location / {
            root   tour-front;
            index  index.html index.htm;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
    
    server {
        listen       8082;
        server_name  localhost;

        location / {
            root   tour;
            index  index.html index.htm;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
```
关闭Nginx
```
nginx.exe -s stop
```
重启Nginx
```
nginx.exe -s reload
```

2.启动Mongodb
* 下载地址：[点击下载](http://downloads.mongodb.org/win32/mongodb-win32-x86_64-3.4.24.zip)
* 下载后需要本地配置，具体请自行搜索([参考地址](https://www.cnblogs.com/TM0831/p/10606624.html))。
```
启动命令：net start mongoDB
```
3.启动Redis
* 下载地址：[点击下载](https://github.com/microsoftarchive/redis/releases/download/win-3.0.504/Redis-x64-3.0.504.zip)
* 下载后需要本地配置，具体请自行搜索([参考地址](https://www.cnblogs.com/skmobi/p/11696620.html))。
```
启动命令：redis-server.exe  --service-start --service-name redisserver
```  
4.启动项目  
* 本地启动  
打开idea选择import project，选择tourismPro或者mongodb-file-server导入，然后等待相关依赖加载完成  
修改tourismPro项目中application.properties配置文件，将你自己的MySQL账号和密码替换写入  
```
#数据源
spring.datasource.url=jdbc:mysql://localhost:3306/tourismPro?useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf8
spring.datasource.username=你自己的MySQL账号
spring.datasource.password=你自己的MySQL密码
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
修改mongodb-file-server项目中application.properties配置文件，将你自己本地创建的数据库替换写入，这里在mongodb中创建了名为tourismPro的数据库
```
spring.data.mongodb.uri=mongodb://localhost:27017/tourismPro
```
如图启动main方法(mongodb-file-server同理)  
![idea启动项目](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200530140655.png)  
5.view address访问地址  
``` 
前台：http://localhost  
后台：http://localhost:8082/index.html  
```

# Quick start-快速部署(另一种部署方式)  
注：使用我配置好的Nginx部署前端项目，通过我打包的jar直接启动后端项目  
* 下载部署包：[百度网盘](https://pan.baidu.com/s/1oHK2AYOtqBVYGYifySjX8Q)   
* 提取码：1bra  

1.工具介绍：  
* 【MongoDB安装包】mongodb-win32-x86_64-3.4.24.zip
* 【MongoDB连接工具】Robo3T_v1.3.1.exe  
* 【Redis安装包】Redis-x64-3.0.504.zip  
* 【Redis连接工具】redis-desktop-manager-0.9.3.817.exe  
* 【Nginx安装包】nginx-1.18.0.zip   
* 【MySql连接工具】Navicat网上一大堆我就不上传了 

2.前端部署： 
* 务必保证系统的80端口、8082端口不被占用  
* 解压nginx-1.18.0-tourismPro.rar  
* 双击解压后nginx-1.18.0-tourismPro目录中的nginx.exe  
* 打开浏览器，输入localhost，再打开新标签输入localhost:8082  
* 页面正常显示则前端部署完成  

3.后端部署：  
* 务必保证系统的8081端口不被占用  
* 务必保证系统已经正确配置了JDK1.8环境变量  
* 务必保证系统正确安装且启动了Redis且未修改默认端口、未设置密码  
* 务必保证系统正确安装且启动了Mongodb且新建了一个名为tourismPro的数据库  
* 务必保证系统安装的是Mysql5.X版本（本项目暂不支持8.X系列的MySQL数据库）且新建了一个名为tourismPro的数据库  
* 安装数据库时设置初始化账号为root，密码为1234  
* 打开cmd或者powershell输入以下命令：     
```
java -jar tourismPro.jar
```
* 打开一个新的cmd或powershell输入以下命令：  
```
java -jar mongodb-file-server.jar
```  
两个jar包启动都不报错则部署成功  

4.验证：  

打开浏览器访问地址  
``` 
前台：http://localhost  
后台：http://localhost:8082/index.html  
```
在后台添加数据查看是否在前台正确展示  

# PS-其他说明
* 本项目使用SpringDataJpa自动构建数据库表，启动项目会自动生成表结构，无需您手动创建
* 启动不能自动构建表，并且报错"Specified key was too long; max key length is xxx bytes"的请保证您的MySQL版本为5.X，并且修改您的数据库编码字符集为utf8 -- UTF-8 Unicode
* 项目使用Redis存储Session会话
* 项目使用MongoDB作为小型文件存储数据库
* 项目中推荐算法部分的实现需要评分数据支撑，请登录不同用户为景点提交评分、评论(每个景点不少于5个评分)

#### 如果您觉得本项目对您有用，烦请您动动手指在页面右上角点个star，谢谢！
   
# Call me-联系方式  
* E-mail：824247231@qq.com  
* QQ：824247231  
* QQ群：696852484  
