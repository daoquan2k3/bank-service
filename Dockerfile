FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build/libs/*.jar app.jar

# Expose port 8080 theo yêu cầu
EXPOSE 8080

# Lệnh khởi động ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]