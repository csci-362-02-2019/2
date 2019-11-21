# Team 2

Hi Professor Bowring or whoever this may concern! 

First things first:
Clone our repo into your home directory

How to produce testReport for test cases
1. Open your terminal
2. cd 2/TestAutomation/scripts
3. bash runAllTests.sh

To add a testcase for a method we have previously tested:
1. Follow the testTemplate.txt which will show you how to make your test case
2. add your new testcase to testCases folder (path:2/TestAutomation)
3. run all tests
	a. cd 2/TestAutomation/scripts
	b. bash runAllTests.sh

To add a testcase for a method we have NOT previously tested:
1. pick out your method to test
	a. needs to take an int, double, long, String, Date, int[], or String[] as an arguement
	b. need to return an int, double, long, String, or Boolean. (Could be something else that can be converted into a String)
	c. needs to be a method that does not rely on other OpenMRS methods
2. copy and paste method from openMRS-core into methods.java (path:2/TestAutomation)
3. Add if else statement to the Driver.java (path:2/TestAutomation) that converts returned type and converts it to a String if needed
4. the condition for the if statement should be "methodCalled.equals("yourMethodNameHere")"
5. now that the output is a string save it to the variable result. ("result = output")
6. write the output as a string to the driverReport.txt by doing writer.write(result)
 
Recreating our fault injections
1. Look at our Deliverable 5 where we went into detail about the parts of the code we changed for each method
2. the methods that you are going to change are located in methods.java (path:2/TestAutomation)

