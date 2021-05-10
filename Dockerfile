FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#Create Workspace for image alpine3

WORKDIR /usr/share/udemy

# ADD (copy) all.jar under target from host into this image alpine3

ADD target/selenium-docker-Udemy.jar		selenium-docker-Udemy.jar
ADD target/selenium-docker-Udemy-tests.jar	selenium-docker-Udemy-tests.jar
ADD target/libs								libs

# in case of any other dependency like .cvs / .json / .xls => please ADD that as well

# ADD (copy) suite files xml

ADD book-flight-module.xml					book-flight-module.xml
ADD search-module.xml						search-module.xml

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh
RUN dos2unix healthcheck.sh

#BROWSER
#HUB_HOST
#MODULE
#!!!!!!Note use colon ":" with Lunix systme alpine3.8!!!!

ENTRYPOINT sh healthcheck.sh