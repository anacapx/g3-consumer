FROM debrum/ubuntu-jdk-mvn
RUN mkdir g3-consumer
COPY . g3-consumer
RUN cd g3-consumer && mvn clean package -Dmaven.test.skip
RUN cp g3-consumer/target/*jar /app-consumer.jar
RUN cp g3-consumer/newrelic/*jar /newrelic-consumer.jar
RUN cp g3-consumer/newrelic/*yml /newrelic.yml
ENV NEW_RELIC_APP_NAME=${NEW_RELIC_APP_NAME}
ENV NEW_RELIC_LICENSE_KEY=${NEW_RELIC_LICENSE_KEY}
ENV NEW_RELIC_LOG_FILE_NAME=${NEW_RELIC_LOG_FILE_NAME}
EXPOSE 8083
ENTRYPOINT ["java","-javaagent:/newrelic-consumer.jar","-jar","/app-consumer.jar"]