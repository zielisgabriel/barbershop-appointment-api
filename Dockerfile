FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

###

FROM gcr.io/distroless/java21-debian12

WORKDIR /app
COPY --from=builder /app/target/barbershop-appointment-api-0.0.1.jar /app/app.jar
ENV SERVER_PORT=8080
EXPOSE 8080
CMD ["/app/app.jar"]