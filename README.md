# KTH Course: DD2480 - Group 13 | LAB 1: Decide

This repository contains the solution for ```DECIDE()``` function for the (version 5) "Launch Interceptor Program: Requirements Specification" (Knight, Leveson, 2016), as the first lab-assignment in the course DD2480, at KTH. 

The program is a "hypothetical anti-ballistic missile system" where the assignment is to write the ```DECIDE()``` function. The function will determine if an interceptor should be launched, based on various combinations of so-called Launch Interceptor Conditions (LIC's). Depending on the combination of LIC's, the function will return a final ouput as a boolean signal; ```"YES"``` or ```"NO"```.

## Prerequisites

To build and run this project, you will need:

* **Java:** Version 8
* **Maven:** Version 3.9.12

**OBS!** Newer version may also work, but this project has been specifically built and tested with the mentioned versions.

### Executing program

1. **Clone the repository**

2. **Run Unit Tests**
    
    You can execute all the tests in ```src/test/java/lab1``` by entering following terminal command: ```mvn test```.

## Statement of contributions

### Member Contributions

**Elinor Selinder:**
- Wrote solutions and unit tests for LIC's 13 and 14
- Wrote solution for CMV implementation and corresponding unit tests
- Reviewed PR's for following issues: LIC 3, 8, 11 (with its corresponding unit tests) and README.md

**Omar Almassri**
- Wrote solutions and unit tests for LIC's 10, 11, 12
- Wrote solution for PUM and corresponding unit tests
- Reviewed PR's for following issues: LIC 2, 5, 7 and ```DECIDE()``` (with its corresponding unit tests)

**Hannes Westerberg**
- Wrote solutions and unit tests for LIC's 4, 5, 6
- Wrote solution for FUV implementation and corresponding unit tests
- Reviewed PR's for following issues: LIC 0, 10, 14 and CMV (with its corresponding unit tests)

**Helin Saeid**
- Wrote solutions and unit tests for LIC's 7, 8, 9 
- Wrote solution for ```DECIDE()`` and corresponding unit tests
- Reviewed PR's for following issues: LIC 1, 4, 12 and PUM (with its corresponding unit tests)

**Liza Aziz**
- Wrote solutions and unit tests for LIC's 0, 1, 2, 3
- Created and organized project folders/files, incl. setting up Maven implementation and handling documentation (README.md & LICENSE.md). 
- Reviewed PR's for following issues: LIC 6, 9, 13 and and FUV (with its corresponding unit tests)

### Remarkable

### Essence Standard
From assignment:

checklist on p.60

"In what state are you in? Why? What are obstacles to reach the next state?"

## License
This project is licensed under the terms of the MIT license.