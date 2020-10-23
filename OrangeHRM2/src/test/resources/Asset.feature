@jahidCode
Feature: Validate login function in Orange HRM 

Scenario: User able to login with valid credential 
	Given user open web browser and navigate to HRM login screen a 
	Then user Navigate to Page and verify the Page Title is "OrangeHRM" a
	And user enter a valid username and password a
	And user click the Sign in button a
	Then user Navigate to Page and verify the Page Title is "OrangeHRM" a
	When user click on log out button for Orange Hrm a
	Then user Navigate to Page and verify the Page Title is "OrangeHRM" a
