Feature: user should be able to login to library.com

  @librarian_login
  Scenario: Login to Library.com
    Given user is on library login page
    When user enters "librarian" valid credentials
    Then user should land on Library Home Page

