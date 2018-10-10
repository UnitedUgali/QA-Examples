package com.company.example;
/**
 * @author Noah Hofmann
 * */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressCorrectionPage extends GeneralPageObject{
	
	private By address_frame = By.className("example_class");
	private By header = By.xpath("example xpath");
	private By proposed_address = By.xpath("example xpath");
	private By users_input = By.xpath("example xpath");
	private By users_address= By.xpath("example xpath");
	private By continue_button = By.xpath("example xpath");
	
	public AddressCorrectionPage(WebDriver driver)
	{
		super(driver);
	}
	
	/**
	 * This method verifies the address correction page 
	 * by checking <web elements>
	 * */
	public boolean verifyPage()
	{
		//an individualized method to wait for a web element defined in another class
		waitForAWebElement(address_frame);
		if(driver.findElement(address_frame).isDisplayed())
		{
			System.out.println("Address correction page verified! - AddressCorrectionPage:verifypage()");
			return true;
		}
		else
		{
			System.out.println("Error! Coulnd't verify address correction page!  - AddressCorrectionPage:verifypage()");
			return false;
			
		}
	}
	/**
	 * This method verifies the test data being displayed on the page.
	 * It does it by comparing the text provided by Cucumber with the text of the webelements
	 * In case you vary the array length
	 * @param This is a list with address details provided by Cucumber.
	 * 		  Each element			
	 * */
	public boolean detailsAreTheSame(List<String> address_details)
	{
		waitForAWebElement(header);
		String header_text = driver.findElement(header).getText();
		String proposed_address_text = driver.findElement(proposed_address).getText();
		String users_input_text = driver.findElement(users_input).getText();
		String users_address_text = driver.findElement(users_address).getText();
		//We split the array to leave all the input titles like "name", "address", etc
		address_details = address_details.subList(address_details.size()/2,address_details.size());
		
		for(String details : address_details)
		{
			//We compare both ways because sometimes the input text is longer
			//and sometimes the selected web element
			if(!(details.contains(header_text)||header_text.contains(details))		
			&&!(details.contains(proposed_address_text)||proposed_address_text.contains(details))
			&&!(details.contains(users_input_text)||users_input_text.contains(details))
			&&!(details.contains(users_address_text)||users_address_text.contains(details)))
			{
				System.out.println("Error! "+details+" hasn't been found!  - AddressCorrectionPage:detailsAreTheSame()");
				return false;
			}
		}
		System.out.println("Success: All  elements have been identified!  - AddressCorrectionPage:detailsAreTheSame()");
		return true;
	}
	
	public boolean clickNext()
	{
		try {
			click(continue_button);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Error! We couldn't click next on the address correction page = AddressCorrectionPage:clickNext()");
			return false;
		}
	}
}
