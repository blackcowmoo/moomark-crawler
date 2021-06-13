
FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine AS builder

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x ./gradlew; sync && ./gradlew
RUN ./gradlew dependencies

COPY . .

RUN ./gradlew clean build

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine

WORKDIR /app
ARG JAVA_OPTS="-XX:MaxRAMPercentage=75.0 -XX:MinRAMPercentage=75.0"

COPY --from=builder $APP/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./app.jar" ]
