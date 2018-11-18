#!/bin/bash
#
#

DAEMON="/usr/bin/java"
PIDFILE="/var/run/kicker.pid"

echo -n "Check kicker"
echo
start-stop-daemon \
 	--start \
	--test \
	--oknodo \
	--pidfile "$PIDFILE" \
	--exec "$DAEMON"
echo "."
