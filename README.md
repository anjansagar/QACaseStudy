# QACaseStudy

ANSWERS:

Point-1:

Concerns/Doubts: 
1.	What are all the schema changes made as part of version 3/ If there are any changes?
2.	Does it support the lower version as well (backward compatibility)?
3.	What is the exact count for invalid logins before returning 403 Forbidden instead of 401 Unauthorized?
4.	What is the default timeout error (In case of huge response)?
5.	Any mocks (Drivers/Stubs) being used?

Approach: 
	To start with
1.	Basic Schema/Field level input validations and Database validation.
2.	Tests for Specifications such as Authorization (Security), Failed login limit, Pagination etc.
3.	Core Functionality/Business Logic
4.	Negative Test Cases
5.	Reliability tests (Rate limiting)
6.	LSPS (Load, Stress, Performance, Scalability) testing

Tests: 
1.	Unit Testing
2.	Functional Testing
3.	Load Testing
4.	Security Testing

Tools: [Java, Rest Assured, TestNG, Jenkins]/[JMeter, Ant, Jenkins]

Endpoint: https://api.github.com/ users/binnujesudasan/repos

Point-2:

Tests can be found at below locations.

https://github.com/binnujesudasan/QACaseStudy/tree/master/src/test/java/com/bootsnipp
https://github.com/binnujesudasan/QACaseStudy/tree/master/src/test/java/com/github/api

Point-3:

Please refer to the Test cases in the below location.

https://github.com/binnujesudasan/QACaseStudy/blob/master/Loyalty_App_Test_Cases.pdf
