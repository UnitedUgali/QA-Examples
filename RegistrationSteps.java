package com.company.example;

import java.util.List;

import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Noah Hofmann
 *
 */
public class RegistrationSteps {
	
	@When("I am on address correction page")
	public void verifyAddressCorrectionPage()
	{
		Assert.assertTrue(addressCorrectionObject.verifyPage(),"Error! Address correction page not recognized.");
	}

	
	@And("^I can see address correction options for Invoice address$")
	public void checkAddressCorrection(List<String> address_details )
	{
		Assert.assertTrue(addressCorrectionObject.detailsAreTheSame(address_details),"Error! The address correction couldn't get verified");
	} 
}