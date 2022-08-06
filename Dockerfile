FROM harbor.ext.hp.com/tropos/java-base-image:latest

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./target/service-quickstart-0.0.1-SNAPSHOT-boot.jar ./app.jar

USER 1002
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
