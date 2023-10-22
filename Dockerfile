FROM eclipse-temurin:17-jdk

WORKDIR /sales
EXPOSE 8080
COPY build/libs/sales-0.0.1-SNAPSHOT.jar sales.jar
ENTRYPOINT ["java", "-jar", "sales.jar"]
