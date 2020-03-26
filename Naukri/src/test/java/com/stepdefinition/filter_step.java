
  package com.stepdefinition;
  
  
  
  
  import com.pages.filter_main;
  
  import cucumber.api.java.en.Given; import cucumber.api.java.en.Then; import
  cucumber.api.java.en.When;
  
  public class filter_step {
  
  filter_main f=new filter_main();
  //To launch chrome browser
  @Given("^user  launchs the chrome browser for filter option$") public void
  user_launchs_the_chrome_browser_for_filter_option() throws Throwable {
  
  f.launchChrome("chrome");
  
  }
  
  //To Launch naukri url
  @When("^user opens the naukri homepage for filter option$") public void
  user_opens_the_naukri_homepage_for_filter_option() throws Throwable {
  
  f.url(); }
  
  //To login to the naukri application
  @Then("^user clicks login button for filter option$") public void
  user_clicks_login_button_for_filter_option() throws Throwable {
  
  f.login(); }
  
  //To search for a job according to filter option
  @Then("^user applys filter$") public void user_applys_filter() throws
  Throwable {
  
  f.search_job(); } }
