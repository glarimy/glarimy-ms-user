FROM openjdk:8-jdk-alpine
MAINTAINER Krishna Mohan Koyya <krishna@glarimy.com>
VOLUME /tmp
EXPOSE 2207
ARG JAR_FILE=target/glarimy-ms-user.jar
ADD ${JAR_FILE} glarimy-ms-user.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/library", "-Djava.security.egd=file:/dev/./urandom","-jar","/glarimy-ms-user.jar"]
