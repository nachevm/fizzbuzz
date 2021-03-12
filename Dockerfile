FROM amazoncorretto:11-alpine-jdk as buildImage
COPY . src
WORKDIR src
RUN ./gradlew build

FROM amazoncorretto:11-alpine-jdk
COPY --from=buildImage src/application/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
