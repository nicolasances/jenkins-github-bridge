FROM openjdk:8-jdk-alpine

RUN mkdir /app

COPY target/jenkins-github-bridge.jar /app

CMD java -jar /app/jenkins-github-bridge.jar
