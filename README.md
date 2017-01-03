# moana
功能描述：
 1、有N张（例如：300）电影票； 
 2、页面上实时（每3s）显示库存电影票剩余数量； 
 3、展示登入界面，使用邮箱账号登入； 
 4、登入后，点击“抢购”，如有，则抢购成功，并发邮件通知； 
 5、用户最多只能抢两张。

技术组件： 
 1、前端使用 Nginx 实现HTTP服务； 
 2、内存数据库 redis
 3、数据持久层使用 mybatis 
 4、数据库使用： mariadb 
 5、系统部署环境： CentOS 7
 
项目配置：
 1、前端Nginx配置，实现代理，处理静态资源请求，转发数据请求；
 2、jdbc.properties配置，修改jdbc.properties文件，配置相应的jdbc连接，用户名及密码；
 3、mail.properties配置，修改mail.properties文件，配置相应的发送邮件帐号及密码
 4、redis.properties配置，修改redis.properties文件，配置相应的host ip、密码等参数
