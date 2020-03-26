
package com.stepdefinition;

import java.io.IOException;

import com.pages.search_main;

import cucumber.api.java.en.Given; import cucumber.api.java.en.Then; import
cucumber.api.java.en.When;

public class search_step {


	search_main ss=new search_main();
	
	//To launch chrome browser and naukri url
	@Given("^user launched the chrome browser for search scenario$") public void
	user_launched_the_chrome_browser_for_search_scenario() { ss.launchChrome("chrome");
	ss.url(); }
	
	//To login to the naukri application
	@When("^user opens naukri homepage for search scenario$") public void
	user_opens_naukri_homepage_for_search_scenario() throws IOException {
		ss.login(); }
	
	//To search for a job 
	@Then("^when user clicks search$") public void when_user_clicks_search()
			throws InterruptedException { ss.search_job(); }

}

