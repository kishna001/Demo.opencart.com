Feature: Feature to test login functionality

Scenario Outline:Login with valid credentials
 		Given user is on OpenCartLoginPage
 		When user enters email "<email>" and password "<password>"
 		Then user should be able login succesfully
 		
Examples:
	| email | password |
	| test@gmail.com    | test123  |
	| hope@gmail.com    | Hp@123 |