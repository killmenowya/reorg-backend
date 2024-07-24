FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar 
COPY ./target/course-details-0.0.1-SNAPSHOT.jar app.jar
ENV SPRING_PROFILES_ACTIVE=dockerembbed,oauth-security
ENTRYPOINT [ "java","-jar","/app.jar" ]