#Build
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY api /app
RUN mvn package -f /app/pom.xml

#Deploy
FROM openjdk-17-slim
WORKDIR /app
COPY --from=build /apptarget/server-0.0.1.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]