FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY /target/choreo-spring-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080

RUN addgroup -g 19042 choreo && \
    adduser  --disabled-password  --no-create-home --uid 19042 --ingroup choreo choreouser

# Switch to the non-root user
USER 19042

CMD ["java", "-jar", "choreo-spring-0.0.1-SNAPSHOT.jar"]
