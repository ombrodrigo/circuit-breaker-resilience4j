#!/bin/bash

NUMBER_REPETITIONS=10
URL="http://localhost:8080/externalRequest/date-time"

while :
do
	for (( i=0; i <= $NUMBER_REPETITIONS; ++i ))
	do
	    curl -XGET $URL &> /dev/null
	done
done
