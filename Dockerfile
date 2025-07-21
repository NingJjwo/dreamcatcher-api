FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/dreamcatcherapi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV MONGODB_URI=${MONGODB_URI}

ENTRYPOINT ["java", "-jar", "app.jar"]