# Description

Test filter can be used for additional test filtering for main Java test frameworks
 
- Junit 4
- Junit 5
- TestNG

 It uses Allure annotations as base for marking up tests.

# Test filter

This is special format string. Base elements are

- Test set **{key:value}**

key - string defining annotation in test mark up
value - Value of this annotation
      
- Set operations: 

Excluding **!**
Intersection **&**
Union **|**

- Additional symbols for convenience

**(**,**)**

Test filter example:

({epic:Task view}|{epic:Inbox})&!{type:Screenshot tests}

# test_filter project structure 

test_filter_calculator - Util for calculation of test filter
test_filter_adaptor - tools for creating new annotations for markup


test_filter_junit4 - adaptor for Junit 4 test framework 
test_filter_junit5 - adaptor for Junit 5 test framework
test_filter_testng - adaptor for TestNG test framework

# How to use

Here is configuration for gradle tests_example




