FROM debrum/ubuntu-jdk-mvn
RUN mkdir g3-consumer
COPY . g3-consumer
RUN cd g3-consumer && mvn clean package -Dmaven.test.skip
RUN cp g3-consumer/target/*jar /app-consumer.jar
RUN rm -rf g3-consumer
EXPOSE 8083
ENTRYPOINT [ "java", "-jar", "/app-consumer.jar" ]