## build
#FROM openjdk:17
#
#COPY target/api-0.0.1.jar /app/api-0.0.1.jar
#
## deploy
#WORKDIR /app
#
#EXPOSE 8080
#
#CMD ["java", "-jar", "/app/api-0.0.1.jar"]


# build
FROM maven:latest AS build
WORKDIR /app
COPY . /app

# deploy
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
