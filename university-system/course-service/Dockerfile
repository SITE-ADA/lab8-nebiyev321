FROM eclipse-temurin:25-jdk AS builder

WORKDIR /workspace
COPY . .
RUN chmod +x gradlew && ./gradlew :course-service:bootJar --no-daemon

FROM eclipse-temurin:25-jre

WORKDIR /app
COPY --from=builder /workspace/course-service/build/libs/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
