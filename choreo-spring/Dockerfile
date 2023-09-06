FROM maven:3.8.7-eclipse-temurin-19-alpine

ADD . /java-springboot
WORKDIR /java-springboot
RUN ls -l
RUN mvn clean install

FROM openjdk:19-alpine
RUN apk add --upgrade libtasn1-progs
RUN apk update && apk upgrade zlib
RUN addgroup -g 10014 choreo && \
    adduser  --disabled-password  --no-create-home --uid 10014 --ingroup choreo choreouser
VOLUME /tmp
USER 10014

# Add Spring Boot app.jar to Container
COPY --from=0 "/java-springboot/target/choreo-*.jar" app.jar

# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]