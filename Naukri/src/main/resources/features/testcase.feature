@naukri_Feature
Feature: naukri website

@tc01_login
Scenario: check that the user can login naukri account
Given user launched the chrome browser 
When user opens naukri homepage 
Then user clicks login 
	
@tc02_search
Scenario:	 check that the user can search for job 
Given user launched the chrome browser for search scenario
When user opens naukri homepage for search scenario
Then when user clicks search 	

@tc03_more
Scenario: check that the user can click more and move to any field
Given  user can launched the chrome browser 
When  user opens the naukri homepage  
Then user clicks login button
And  user can click more and move to any field	
	
@tc04_filter
Scenario:	 check that the user is able to apply filter
Given  user  launchs the chrome browser for filter option
When  user opens the naukri homepage for filter option
Then user clicks login button for filter option
And  user applys filter
