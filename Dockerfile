FROM openjdk:8
LABEL maintainer="Mohammad Anbari"
ADD target/analytics.jar analytics.jar
ENTRYPOINT ["java", "-jar", "analytics.jar"]
