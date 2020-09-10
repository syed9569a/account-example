#!/bin/bash

java -jar target/*.jar > /var/log/java.service &

echo $(pwd) > /var/log/java.service

