#Author: your.email@your.domain.com

Feature: Mobile Search Validation


 
  #Scenario: Mobile purchase Validation
   #Given User lauch Flipkart URL
   #And user enter mobiles in search option
  #When click the particular mobiles in the list
  #And sclick add to cart option
 
 Scenario: Mobile purchase Validation using 1 dim list
   Given User lauch Flipkart URL
   And user enter mobiles in search option
When click the particular mobiles in the list using 1 dim list
  |Samsung|iphone|Redmi|
  And sclick add to cart option

  