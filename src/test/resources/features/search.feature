Feature: Check an item can be searched and added to the basket

  Scenario: Search for an item and add to the basket via quick add
    Given The Gymshark homepage has successfully loaded
    When I search for an item I should see a list of matching search results
    Then I will choose an item and size which will get added to the cart
    When The cart has opened then I will click on checkout button
    Then I will be redirected to the information page
    When I click continue to shipping after filling out the mandatory fields on information
    Then I will be taken to the shipping page
    When I click on the continue to payment button
    Then I will be taken to the payment page


  Scenario: Search for an item and add 2 items to the basket via basket
    Given The Gymshark homepage has successfully loaded
    When I search for an item I should see a list of matching search results
    Then I will choose an item and size which will get added to the cart
    When The minicart is open and i click on the x button
    Then The minicart will close
    Then I will add another item which will get added to the cart
    When The cart has opened then I will click on checkout button
    Then I will be redirected to the information page
    When I click continue to shipping after filling out the mandatory fields on information
    Then I will be taken to the shipping page
    When I click on the continue to payment button
    Then I will be taken to the payment page
