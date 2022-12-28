#!/bin/bash

java -version
APP_NAME=gameserver



PID=$(pgrep -f ${APP_NAME})

for id in $PID
do
  kill "$id"
  echo "kill $id"
done

num=1
while true
do
    old_pid=$(pgrep -f ${APP_NAME})
    if [ -z "$old_pid" ];
    then
         echo "$PID stopped"
         break;
    else
         echo "wait $old_pid stop ${num}s... "
         num=$((num + 1))
         sleep 1
    fi
done


JAVA_PARAMS="-Xmx1024m -Xms1024m -Xmn384m -XX:+PrintGC -XX:+PrintGCDetails -Xloggc:gc.log --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -Dzookeeper.sasl.client=false"
PROD=test


echo ${APP_NAME} to start

java $JAVA_PARAMS org/springframework/boot/loader/JarLauncher --spring.profiles.active=$PROD --$APP_NAME> stdout.log 2>&1 &

num=1
while ((num <= 50))
do
	sleep 5
	result=$(curl -s http://127.0.0.1:22306/manager/checkServer|awk -F ":" '{print $2}'|awk -F "}" '{print $1}')
	echo "$result"
	if [ "0" == "$result" ];then
		echo ${APP_NAME} is started !!!!
		exit 0
	else
		echo ${APP_NAME} is not started try again !!!
	fi
	num=$((num + 1))
done

echo ${APP_NAME} start is timeout !!!
exit 1





