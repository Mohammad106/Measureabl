Feature:profile


  Scenario:User should be able to select random value for the dropdown
    Given User is in login page
    And user enter his userID and Password
    And user click on login button
    And user click on profile
    And user select random value and save it
    Then user will verify he can select value


    Scenario:User verify selected value
      Given User is in login page
      And user enter his userID and Password
      And user click on login button
      And user click on profile
      Then user varify the selected value