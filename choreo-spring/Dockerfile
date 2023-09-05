FROM eclipse-temurin:17-jdk-alpine

# Create a non-root user
RUN adduser -D -u 1001 myuser

WORKDIR /app
COPY /target/choreo-spring-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080

# Switch to the non-root user
USER myuser

CMD ["java", "-jar", "choreo-spring-0.0.1-SNAPSHOT.jar"]
