FROM eclipse-temurin:17-jdk-alpine AS build
RUN addgroup -g 11000 choreo && \
    adduser --disabled-password --no-create-home --uid 11000 --ingroup choreo choreouser \
USER 11000
ADD . /app
WORKDIR /app
COPY . .
RUN ./mvnw  clean install
FROM eclipse-temurin:17-jdk-alpine
RUN addgroup -g 19042 choreo && \
    adduser --disabled-password --no-create-home --uid 19042 --ingroup choreo choreouser
WORKDIR /app
COPY --from=build /app/target/choreo-spring-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
USER choreouser
CMD ["java", "-jar", "choreo-spring-0.0.1-SNAPSHOT.jar"]
