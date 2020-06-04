FROM java:8u111

VOLUME /tmp

ADD target/mybatis-plustest-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","/app.jar"]

# Ubuntu 时区
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime