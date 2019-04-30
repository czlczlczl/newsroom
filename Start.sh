#!/bin/bash

java -jar ./target/newsroom-0.0.1-SNAPSHOT.jar &
echo $! > ./target/web.pid
