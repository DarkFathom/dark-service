#!/bin/bash
echo 'Deploying to Jboss'
$JBOSS_HOME/bin/jboss-cli.sj -c --command='deploy ./build/*.war --force'
