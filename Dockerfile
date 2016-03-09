FROM java:8
MAINTAINER piotr.szulawski@hpe.com
ARG SERVER_PORT=3000
ENV SERVER_PORT $SERVER_PORT
ADD gitmetrics-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE $SERVER_PORT