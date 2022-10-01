FROM openjdk:11
COPY build/libs/*.jar /
EXPOSE 8081
ENTRYPOINT ["java","-jar","/country-app-0.0.1-SNAPSHOT.jar"]
