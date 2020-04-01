#!/bin/bash
echo 'Deploying to Jboss'
$JBOSS_HOME/./jboss-cli.sh -c '--commands=deploy /build/*.war --force'
