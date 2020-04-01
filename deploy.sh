#!/bin/bash
echo 'Deploying to Jboss'
$JBOSS_HOME/bin/./jboss-cli.sh -c '--commands=deploy /build/*.war --force'
