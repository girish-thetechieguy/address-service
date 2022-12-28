ARG JDK_VERSION
FROM openjdk:${JDK_VERSION}
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} address-service.jar
ENTRYPOINT ["java","-jar","/address-service.jar"]