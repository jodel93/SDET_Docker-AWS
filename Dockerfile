FROM openjdk:8u191-jre-alpine3.8
#WORKSPACE
WORKDIR /usr/share/udemy
#Adding .jar from host
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs
#Adding suite files
ADD testNG.xml                          testNG.xml
#BROWSER
#HUB
#MODULE
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER  -DHOST=$HOST org.testng.TestNG $MODULE
