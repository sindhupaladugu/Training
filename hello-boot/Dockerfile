FROM openjdk:8
ARG JAR_FILE=target/hello-bbot.jar
COPY ${JAR_FILE} hello-bbot.jar
EXPOSE 8780
ENTRYPOINT ["java","-jar","/hello-boot.jar"]