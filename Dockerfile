FROM java:8
MAINTAINER piotr.szulawski@hpe.com
ARG SERVER_PORT=3000
ENV SERVER_PORT $SERVER_PORT
EXPOSE $SERVER_PORT
ADD target/gitmetrics-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar app.jar
