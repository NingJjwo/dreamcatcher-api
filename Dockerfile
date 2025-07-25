FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/dreamcatcherapi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV MONGODB_URI=${MONGODB_URI}
ENTRYPOINT ["java", "-jar", "app.jar"]