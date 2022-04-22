FROM openjdk:19-jdk-alpine3.15

ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./data ./data
ENTRYPOINT [ "java","-jar","/app.jar" ]
