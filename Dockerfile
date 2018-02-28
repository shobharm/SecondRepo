FROM openjdk:8
MAINTAINER Name m.shobha@tcs.com
EXPOSE 8086
RUN mkdir /homejar
COPY TestSpringBootJS /homejar/TestSpringBootJS
RUN ls -la /homejar/TestSpringBootJS/target
CMD exec java -jar "/homejar/TestSpringBootJS/target/first.jar"
