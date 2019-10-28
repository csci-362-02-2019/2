#!/bin/bash

echo "changing directory to testCases."
cd /home/wright/testCases
echo "read test cases"

#rm -r ../reports/* #clear the reports directory.

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


