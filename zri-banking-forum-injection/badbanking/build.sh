#!/bin/sh

mvn clean package

mvn tomcat7:undeploy

mvn tomcat7:deploy
