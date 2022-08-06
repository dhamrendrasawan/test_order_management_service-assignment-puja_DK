FROM harbor.ext.hp.com/tropos/flyway-migrate:latest
ENV FLYWAY_APP_HOME=/home/app

WORKDIR $FLYWAY_APP_HOME
ADD flyway-migrations .
COPY flyway-migrations/*.sql /home/app/flyway-migrations/
COPY flyway_entrypoint.sh .
USER root 
RUN chmod +x ./flyway_entrypoint.sh
USER 1002
ENTRYPOINT ["bash","-c","${FLYWAY_APP_HOME}/flyway_entrypoint.sh"]
