Feature:SignUp



  Scenario:User should be able to sign up using valid credentials
    Given User is in login page
    And user click on create account link
    And user will verify that he is on correct page
    And user fill out the form
    And user check the check box
    When user click on create account button
    Then user successfully create his account

    Scenario:User should not be able to sign up if they keep email field empty
      Given User is in login page
      And user click on create account link
      And user fill out the form keep email field empty
      And user check the check box
      When user click on create account button
      Then user should not be able to create his account