FROM openjdk:17
LABEL maintainer = "harsha"
COPY target/Hai-0.0.1-SNAPSHOT.jar hai-backend.jar
CMD java -jar hai-backend.jar


