FROM openjdk:11
WORKDIR /app
EXPOSE 8080
ADD /target/chatty-0.0.1-SNAPSHOT.jar /app/chatty-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java". "-jar", "/app/chatty-0.0.1-SNAPSHOT.jar"]
