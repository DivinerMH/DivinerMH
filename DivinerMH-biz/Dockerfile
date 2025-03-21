# Docker image for springboot file run
# VERSION 0.0.1
# Author: diviner119
# 基础镜像使用java （java:8是指Docker Hub上官方提供的java镜像，版本号是8也就是jdk1.8）
FROM java:8

# 作者
MAINTAINER diviner119 <diviner119@163.com>

# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp

# 将jar包添加到容器中并更名为app.jar
ADD DivinerMH-biz-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# 运行jar包
RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]