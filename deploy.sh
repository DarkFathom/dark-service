#!/bin/bash
echo 'Deploying to Jboss'
$JBOSS_HOME/bin/jboss-cli.sh -c --command='deploy ./build/*.war --force'
