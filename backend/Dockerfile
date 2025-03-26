# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the backend port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
