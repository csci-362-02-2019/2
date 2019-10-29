#!/bin/bash

echo "changing directory to testCases."
cd /home/wright/testCases
echo "read test cases"

rm -r /home/wright/testCases/reports/* #clear the reports directory.

echo "<!DOCTYPE html>" >> /home/wright/testCases/reports/testReport.html
echo "<html>" >> /home/wright/testCases/reports/testReport.html
echo "<head>" >> /home/wright/testCases/reports/testReport.html
echo "<title> Test Report</title>" >> /home/wright/testCases/reports/testReport.html
echo "</head>" >> /home/wright/testCases/reports/testReport.html
echo "<body>" >> /home/wright/testCases/reports/testReport.html
echo "<table border=1 style=width:75%>" >> /home/wright/testCases/reports/testReport.html
echo "<tr>" >> /home/wright/testCases/reports/testReport.html
echo "<th> Test # </th>" >> /home/wright/testCases/reports/testReport.html
echo "<th> Requirement </th>" >> /home/wright/testCases/reports/testReport.html
echo "<th> class name </th>" >> /home/wright/testCases/reports/testReport.html
echo "<th> method name </th>" >> /home/wright/testCases/reports/testReport.html
echo "<th> input </th>" >> /home/wright/testCases/reports/testReport.html
echo "<th> expected output </th>" >> /home/wright/testCases/reports/testReport.html
echo "<th> actual output </th>" >> /home/wright/testCases/reports/testReport.html
echo "<th> pass/fail </th></tr>" >> /home/wright/testCases/reports/testReport.html

testCaseTracker=0 #tracks the number of the test case being worked on.
lineStorage=( ) #array for storing lines from testCase files

for filename in * 
do
echo "<tr>" >> /home/wright/testCases/reports/testReport.html

	counter=0
		while IFS='' read -r line;do #reads lines from a test Case file
			lineStorage[$counter]="$line"
# 0=testCaseNumber, 1=Requirement, 2=ClassName, 3=MethodName, 4=input, 5=expectedOutput, 6=classpath, # 7=DriverName

		if [ "$counter" -eq 0 ] || [ "$counter" -eq 1 ] || [ "$counter" -eq 2 ] || [ "$counter" -eq 4 ]
		 then 
			echo "<td>" >> /home/wright/testCases/reports/testReport.html
			echo ${lineStorage[$counter]} >> /home/wright/testCases/reports/testReport.html

	
elif [ "$counter" -eq 3 ];then
        	        echo "<td>" >> /home/wright/testCases/reports/testReport.html
              
        	       METHOD=${lineStorage[$counter]}
        	       MyMethod=${METHOD##* }
        	        echo $METHOD | sed 's/,.*//' >> /home/wright/testCases/reports/testReport.html
		
		  fi



	((counter++))
	        echo "</td>" >> /home/wright/testCases/reports/testReport.html
	done < "$filename"

cd ..


#prints out expected output from test case
echo "<td>" >> /home/wright/testCases/reports/testReport.html
echo ${lineStorage[5]}>> /home/wright/testCases/reports/testReport.html
echo "</td>" >> /home/wright/testCases/reports/testReport.html 

#pipes input into java driver classes and puts them in html table
output=$(echo ${lineStorage[4]} | java -classpath ${lineStorage[6]} ${lineStorage[7]} "${lineStorage[4]}")
echo "<td>" >> /home/wright/testCases/reports/testReport.html
echo $output >> /home/wright/testCases/reports/testReport.html
echo "</td>" >> /home/wright/testCases/reports/testReport.html

#compares expected output to actual output and decides if test passed or failed
echo "<td>" >> /home/wright/testCases/reports/testReport.html
if [ "$output" == "${lineStorage[5]}" ];then	
	echo "<p style="color:green"> Passed.</p>" >> /home/wright/testCases/reports/testReport.html 

else
	echo "<p style="color:red"> Failed.</p>" >> /home/wright/testCases/reports/testReport.html 
fi
echo "</td>" >> /home/wright/testCases/reports/testReport.html




echo "</tr>" >> /home/wright/testCases/reports/testReport.html #ends a row in the table
echo "test case $testCaseTracker complete"
((testCaseTracker++))
cd testCases
done

cd /home/wright/testCases/reports

xdg-open testReport.html


