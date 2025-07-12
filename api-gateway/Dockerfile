# Base JDK
FROM openjdk:17-jdk-slim

# Create folder for app
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app_apigateway.jar

# Exposed Port specified in Docker Compose

# Command to execute the app
ENTRYPOINT ["java", "-jar", "app_apigateway.jar"]