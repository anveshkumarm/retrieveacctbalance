#!/bin/sh

javac RetrieveRelativeAcctBalance.java
echo -e "\nRun 1:  java RetrieveRelativeAcctBalance ACC334455 "20/10/2018 12:24:55" "20/10/2018 19:00:00"\n"
java RetrieveRelativeAcctBalance ACC334455 "20/10/2018 12:24:55" "20/10/2018 19:00:00"

echo -e "\nRun 2:  java RetrieveRelativeAcctBalance ACC998877 "20/10/2018 12:24:55" "21/10/2018 19:00:00"\n"

java RetrieveRelativeAcctBalance ACC998877 "20/10/2018 12:24:55" "21/10/2018 19:00:00"

echo -e "\nRun 3:  java RetrieveRelativeAcctBalance ACC334455 "20/10/2018 12:24:55" "21/10/2018 19:00:00"\n"
java RetrieveRelativeAcctBalance ACC334455 "20/10/2018 12:24:55" "21/10/2018 19:00:00"


