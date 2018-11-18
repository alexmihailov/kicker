#!/bin/bash
#
#
JAR_PATCH="/home/alex/Documents/works/kicker/deploy/app/kicker-0.0.1-SNAPSHOT.jar"
PROPERTY_PATCH="file:/home/alex/Documents/works/kicker/deploy/app/config/application.properties"

DAEMON="/usr/bin/java"
DAEMON_ARGS=" -jar $JAR_PATCH --spring.config.location=$PROPERTY_PATCH"

PIDFILE="/var/run/kicker.pid"

echo -n "Starting kicker"
echo
start-stop-daemon \
 	--start \
	--pidfile "$PIDFILE" \
	--verbose \
	--make-pidfile \
	--background \
	--exec "$DAEMON" \
	-- $DAEMON_ARGS
echo
echo "done"
