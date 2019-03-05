FROM openjdk:8u181-jre

USER root

WORKDIR /app

COPY build/libs/hello-web-0.0.1-SNAPSHOT.jar /app

EXPOSE 9001

CMD ["java", "-jar", "hello-web-0.0.1-SNAPSHOT.jar"]
