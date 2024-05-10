#!/bin/sh

echo "The app is starting ..."
exec java -jar -Dspring.profiles.active=${SPRING_ACTIVE_PROFILES} "products-1.jar"