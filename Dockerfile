FROM openjdk:17
ADD target/spring-docker-mongo.jar spring-docker-mongo.jar
ENTRYPOINT ["java","-jar","spring-docker-mongo.jar"]
