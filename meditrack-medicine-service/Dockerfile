# -----------------------BUILD-------------------------
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn -pl meditrack-medicine-service -am clean package -DskipTests
# -----------------------RUNTIME-------------------------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/meditrack-medicine-service/target/*.jar medicine.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "medicine.jar"]