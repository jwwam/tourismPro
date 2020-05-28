# tourismPro旅游网站
这是一个轻量化、简单、易上手的旅游网站项目，系统包括完整的前端Html页面和后台代码，该项目仅适合作为JavaWeb入门或毕业设计使用，不具备实际使用价值，项目中涉及皮尔逊相关系数的相似度算法Java实现和实际应用可查看景点推荐模块。

# Project description-项目描述 
* 此项目为tourism的重构版本【tourism是3年前做的一个旅游网站毕业设计，采用ssh架构】  
* 因为tourism开发时间久远，现在对这个项目进行了全新升级  
* 本次升级抛弃了原来一些老旧的技术，底层的所有代码全部重写  
* 采用前后端分离架构  
* 前端页面进行了升级，引用了一些基本的组件，如dataTables.js、bootstrap.js、bootbox.js  
* 前端没有采用主流框架如Vue、React等，使用基本的HTML+CSS+JQ也减轻了上手难度  
* 引入皮尔逊线性相似度推荐算法的Java实现，应用于项目的“景点推荐”栏目   
 
# Project framework-项目架构   
![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/projectFramework.png)    
* 采用前后端分离，Jquery + SpringBoot2.0    
* 后端语言Java  
* ORM使用SpringDataJPA    
* 数据库使用MySql5.7+Mongodb3   
* 缓存Redis  
* 部署Nginx+Jar  

# Project algorithm-相关算法  
* 皮尔逊相关系数的相似度算法(Pearson)  
* 以下给出其实现公式：  
![相关算法](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20150218130748809.png)   
该算法在本系统中实现了基于景点分数近似度的推荐功能，以下给出数据获取方法代码，具体算法实现请查看CFUtils.cosineSimilarity()方法。
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


# Run-启动访问  
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
修改tourismPro项目中application.properties配置文件，将你自己的MySQL账号和密码替换写入  

```
#数据源
spring.datasource.url=jdbc:mysql://localhost:3306/tourismPro?useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf8
spring.datasource.username=你自己的MySQL账号
spring.datasource.password=你自己的MySQL密码
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
修改mongodb-file-server项目中application.properties配置文件，将你自己本地创建的数据库替换写入，这里创建了名为tourismPro的mongodb数据库
```
spring.data.mongodb.uri=mongodb://localhost:27017/tourismPro
```
1.启动Nginx
```
nginx.exe
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
* 启动tourismPro
```
java -jar tourismPro.jar
```
* 启动mongodb-file-server
```
java -jar mongodb-file-server.jar
```  
5.view address  
``` 
前台：http://localhost:8082/index.html  
后台：http://localhost  
```

# Call me-联系方式  
* E-mail：zhulier1124@gmail.com
* QQ：824247231
* QQ群：696852484
