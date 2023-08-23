Feature: Login Page
  As a user
  I want to access the login page
  So that I can log in to the application

  Scenario: User accesses the login page
    Given the user is on the homepage
    When the user fill correct user "dhea.arvie@formulatrix.com" and password "123456" and login
    Then the user should be directed to the login page