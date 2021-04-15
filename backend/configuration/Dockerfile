FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} host-trainee.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/host-trainee.jar"]