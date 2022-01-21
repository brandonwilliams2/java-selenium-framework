#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# FEATURE

echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command / NOTE: if on Windows use ; as a package separator. Mac/Linux use :
java -cp java-selenium.jar:java-selenium-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -DBROWSER=$BROWSER \
    org.testng.TestNG $FEATURE