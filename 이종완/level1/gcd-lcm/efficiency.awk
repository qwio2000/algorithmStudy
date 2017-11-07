#!/usr/local/bin/bash

cat input.txt | 
    xargs -L1 java -jar gcdlcm-0.1.jar ${1:-0} |
    awk '
BEGIN {
    countSum = 0
    loopSum = 0
    record = 0
}
/^Count/ {
    countSum += $2
    loopSum += $4
    record++
    print
}
END {
    print "================"
    print "Count Sum\t: " countSum
    print "Loop Sum\t: " loopSum
    if (record > 0) {
        print "Count Average\t: " countSum/record
        print "Loop Average\t: " loopSum/record
    }
}'
