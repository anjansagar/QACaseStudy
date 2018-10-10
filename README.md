# QACaseStudy

1. Please read the documentation of the GitHub API at < https://developer.github.com/v3 >. Suppose that you worked with a team that was tasked with implementing this specification.
	a. What concerns would you have from a testing perspective?
	b. How would you go about tackling the QA for this work?
	c. What sort of tests would be worth describing or worth automating?
	d. What tools would you use?
	e. Please select an endpoint to test and implement a test suite for that endpoint.You may choose a tech stack of your choice for the tests.

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

Tools: [Java, Rest Assured, TestNG, Jenkins]/[JMeter/Ant/Jenkins].
Endpoint: https://api.github.com/ users/binnujesudasan/repos