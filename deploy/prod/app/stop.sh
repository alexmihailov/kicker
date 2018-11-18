#!/bin/bash
#
#

DAEMON="/usr/bin/java"

PIDFILE="/var/run/kicker.pid"

echo -n "Stoping kicker"
echo
start-stop-daemon \
 	--stop \
	--pidfile "$PIDFILE" \
	--make-pidfile \
	--exec "$DAEMON" \
	--retry=TERM/30/KILL/5
echo
echo "done"
