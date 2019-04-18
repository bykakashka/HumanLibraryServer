FROM maven:3.5.2-jdk-8-alpine AS MAVEN
COPY pom.xml /tmp/
COPY src /tmp/src
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jdk-alpine
COPY --from=MAVEN /tmp/target/*.war /app.war
ENTRYPOINT ["java","-jar","/app.war"]