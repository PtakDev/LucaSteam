FROM openjdk:latest
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
COPY ./datos ./datos
ENTRYPOINT ["java","-jar","/app.jar"]
