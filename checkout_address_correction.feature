@example_tag
Feature: Address correction 

  As a regular user I would want to see my delivery or invoice address corrected 
  in case my input contains typos

  Background:
  	Given I start the test environment
    Given I am on "Example Company" landing page

  Scenario: We propose the user an address our location service was able to find with the users input
    When I am on the address correction page
    Then I can see address correction options for the address
      | header   | proposedAddress                 | usersInput  | usersAddress                    |
      | Address  | Example Avenue 29, Example City | Your Input: | Example Avenue 29, Example City |
   