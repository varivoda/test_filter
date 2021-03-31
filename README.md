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
test_filter_adaptor - код для написания своих аннотаций разметки и вычисления тестовых координат


test_filter_junit4 - адаптор для тестов на Junit 4 
test_filter_junit5 - адаптор для тестов на Junit 5
test_filter_testng - адаптор для тестов на TestNG

tests_example - модуль с примерами тестов.

# Подключение в проект

