FROM openjdk:11
WORKDIR /app/usr
EXPOSE 8080
COPY /target/chatty-*.jar /app/usr
CMD java -jar /app/chatty-*.jar
