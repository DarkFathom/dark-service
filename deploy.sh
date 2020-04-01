#!/bin/bash
echo 'Deploying to Jboss'
#$JBOSS_HOME/./jboss-cli.sh -c '--commands=deploy /build/*.war --force'
sudo /opt/jboss-eap/bin/./jboss-cli.sh -c '--commands=deploy /home/jenkins/workspace/nameservice_master/build/libs/dark-service.war --force'
