@Authentication
Feature: Authentication feature
  As a user, I want to login to my account in order to generate my account

  @ValidCredentials
  Scenario Outline: I want to verify the login Page and try to connect to my account with a valid credentials
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "<username>"
    And I enter a valid data for the password field "<password>"
    And I click on the Login button
    Then I head toward the inventory page "Products"

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  @LockedCredentials
  Scenario: I want to verify the login Page and try to connect to my account with a locked credentials
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "locked_out_user"
    And I enter a valid data for the password field "secret_sauce"
    And I click on the Login button
    Then I receive an error message for locked users "Epic sadface: Sorry, this user has been locked out."

  @InvalidCredentials
  Scenario Outline: I want to verify the login Page and try to connect with an invalid credentials
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "<username>"
    And I enter a valid data for the password field "<password>"
    And I click on the Login button
    Then I receive an error message for invalid users "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | username  | password |
      | cristiano | ronaldo  |
      | reberry   | frank    |
      | leonel    | messi    |
      | ferjeni   | sessi    |

  @Logout
  Scenario: I want to login with a valid credentials and try to logout
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "performance_glitch_user"
    And I enter a valid data for the password field "secret_sauce"
    And I click on the Login button
    And I head toward the inventory page "Products"
    And I click on the menu Icon
    And I click on the logout button
    Then I head toward the authentication Page "Accepted usernames are:"
    
