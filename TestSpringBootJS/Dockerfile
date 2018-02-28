FROM openjdk:8
MAINTAINER Name m.shobha@tcs.com
EXPOSE 8086
RUN mkdir /homejar
ADD /home/tcs/Documents/workspace-sts-3.9.0.RELEASE/TestSpringBootJS /homejar
CMD exec java -jar "/homejar/TestSpringBootJS/target/first.jar"