Feature: Book A Filght Ticket with LowCost
  Scenario Outline: Check for the low cost and book a ticket
    Given Navigate to <url>
    When Select the from and To city and enter the date aswell and click the search button
    And click on th booknow and continue for next process and switch to next child window and continue and enter the personal deatils which are reqired
    Then print the flight booking is succesfully done
    Examples:
      | url                       |
      |https://www.makemytrip.com/|