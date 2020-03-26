
  package com.stepdefinition;
  
  import com.pages.login_main;
  
  import cucumber.api.java.en.Given; import cucumber.api.java.en.Then; import
  cucumber.api.java.en.When;
  
  public class login_step extends login_main {
  //To launch chrome browser	
  @Given("^user launched the chrome browser$") public void
  user_launched_the_chrome_browser() throws Throwable { launchChrome("chrome"); }
  
  //To launch naukri url
  @When("^user opens naukri homepage$") public void
  user_opens_naukri_homepage() throws Throwable { url(); }

  //To login to naukri application using valid login credentials and to take screenshot
  @Then("^user clicks login$") public void user_clicks_login() throws Throwable
  { 
	  login();
  }
  
  }
 