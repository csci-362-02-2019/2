#!/bin/bash

echo "changing directory to testCases..."
cd testCases
echo "reading test cases..."

rm -r ../reports/*	#clear the reports directory
#sets up initial html Doc---------------------------------------------------
echo "<!DOCTYPE html>" >>../reports/testReport.html
echo  "<html>" >> ../reports/testReport.html
echo "<head>" >> ../reports/testReport.html
echo  "<title>Test Report</title>" >> ../reports/testReport.html
echo  "</head>" >> ../reports/testReport.html
echo  "<body>" >> ../reports/testReport.html
echo  "<table border=1 style=width:75%>" >> ../reports/testReport.html
echo  "<tr>" >> ../reports/testReport.html
echo  "<th> Test # </th>">> ../reports/testReport.html
echo  "<th> Requirement </th>" >> ../reports/testReport.html
echo  "<th> class name </th>">> ../reports/testReport.html
echo  "<th> method name </th>">> ../reports/testReport.html
echo  "<th> input </th>">> ../reports/testReport.html
echo  "<th> expected output </th>">> ../reports/testReport.html
echo  "<th> actual output </th>" >> ../reports/testReport.html
echo  "<th> pass/fail </th></tr>">> ../reports/testReport.html
#-----------------------------------------------------------------------------
#-----------------------------------------------------------------------------



testCaseTracker=1  #tracks what test case is being worked on
lineStorage=( ) #array for storing lines from test case files
for filename in *    #goes through all the files in testCase dir
do
echo "<tr>" >> ../reports/testReport.html
   
   counter=0
	while IFS='' read -r line;do #reads lines from a test Case file
	   lineStorage[$counter]="$line" 
#0=TestCaseNumber, 1=Requirement, 2=ClassName, 3=MethodName, 4=input, 5=expectedOutput, 6=classpath, 7=DriverName
	  if [ "$counter" -eq 0 ] || [ "$counter" -eq 1 ] || [ "$counter" -eq 2 ] || [ "$counter" -eq 4 ] 
	   then
		echo "<td>" >> ../reports/testReport.html
		echo ${lineStorage[$counter]} >> ../reports/testReport.html
           elif [ "$counter" -eq 3 ];then
                echo "<td>" >> ../reports/testReport.html
              
               METHOD=${lineStorage[$counter]}
               MyMethod=${METHOD##* }
                echo $METHOD | sed 's/,.*//' >> ../reports/testReport.html
		
	  fi






	((counter++))
	        echo "</td>" >> ../reports/testReport.html
	done < "$filename"


cd .. #go back to TestAutomation directory

#prints out expected output from test case
echo "<td>" >> reports/testReport.html
echo ${lineStorage[5]}>> reports/testReport.html
echo "</td>" >> reports/testReport.html

#pipes input into java driver classes and puts them in html table
output=$(echo ${lineStorage[4]} | java -classpath ${lineStorage[6]} ${lineStorage[7]} "${lineStorage[4]}")
echo "<td>" >> reports/testReport.html
echo $output >> reports/testReport.html
echo "</td>" >> reports/testReport.html


#compares expected output to actual output and decides if test passed or failed
echo "<td" >> reports/testReport.html
if [ "$output" == "${lineStorage[5]}" ];then
   echo "style=\"color:#0D7010;\">Passed" >> reports/testReport.html
else
   echo "style=\"color:#FF0000;\">Failed" >> reports/testReport.html
fi
echo "</td>" >> reports/testReport.html




echo "</tr>" >> reports/testReport.html #ends a row in the table
echo "test case $testCaseTracker complete"
((testCaseTracker++))
cd testCases
done

cd ../reports #goes to report dir

xdg-open testReport.html #opens the html file
