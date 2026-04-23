FROM eclipse-temurin:25-jdk AS builder

WORKDIR /workspace
COPY . .
RUN chmod +x gradlew && ./gradlew :student-service:bootJar --no-daemon

FROM eclipse-temurin:25-jre

WORKDIR /app
COPY --from=builder /workspace/student-service/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
