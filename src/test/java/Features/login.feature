Feature:Login


  Scenario: User should be able to login using valid credentials
    Given User is in login page
    And user verify he is in correct page
    And user enter his userID and Password
    When user click on login button
    Then User will successfully login


    Scenario: User should not be able to login using invalid credentials
      Given User is in login page
      And user verify he is in correct page
      And user enter their invalid userID and Password
      When user click on login button
      Then User will not be able to login