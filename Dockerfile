FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq
#WORKSPACE
WORKDIR /usr/share/udemy
#Adding .jar from host
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs
#Adding suite files
ADD testNG.xml                          testNG.xml
ADD testNG2.xml                         testNG2.xml

ADD healthcheck.sh                      healthcheck.sh
#BROWSER
#HUB
#MODULE
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHOST=$HOST -DBROWSER=$BROWSER org.testng.TestNG $MODULE
