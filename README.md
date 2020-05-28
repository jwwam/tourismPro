# tourismPro旅游网站

# What is tourismPro?
* 这是一个轻量化、简单、易上手的旅游网站项目，架构包括完整的前端和后台，仅适合作为JavaWeb入门或毕业设计使用。

# ProjectDescription-项目描述 
* 此项目为tourism的重构版本【tourism是3年前做的一个旅游网站项目，采用ssh架构】  
* 因为tourism开发时间久远，现在对这个项目进行了全新升级  
* 本次升级抛弃了原来一些老旧的技术，底层的所有代码全部重写  
* 采用前后端分离架构  
* 前端页面进行了升级，引用了一些基本的组件，如dataTables.js、bootstrap.js、bootbox.js  
* 前端没有采用主流框架如Vue、React等，使用基本的HTML+CSS+JQ也减轻了上手难度  
* 引入皮尔逊线性相似度推荐算法的Java实现，应用于项目的“景点推荐”栏目   
 
# ProjectFramework-项目架构  
![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/projectFramework.png)   
* 采用前后端分离，Jquery + SpringBoot2.0    
* 后端语言Java  
* ORM使用SpringDataJPA    
* 数据库使用MySql5.7+Mongodb3   
* 缓存Redis  
* 部署Nginx+Jar  

# ViewPage-页面预览如下：
注：看不到图片可能需要梯子(maybe u need VPN)  

* 前端首页：  

![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511000840.png)   
* 后台列表：  

![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511001624.png)   
* 后台数据添加：  

![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511001710.png)   
 
 * 前台酒店推荐  
 ![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511010248.png)   
  
 * 前台旅游线路  
 ![avatar](https://github.com/jwwam/tourismPro/blob/master/src/main/resources/static/20200511020238.png)   


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
```
net start mongoDB
```
3.启动Redis
```
redis-server.exe  --service-start --service-name redisserver
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
5.view 
``` 
前台：http://localhost:8082/index.html  
后台：http://localhost  
```

# Callme-联系方式  
* E-mail：zhulier1124@gmail.com
* QQ：824247231
* QQ群：696852484
