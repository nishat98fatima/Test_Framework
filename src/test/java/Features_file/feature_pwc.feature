Feature: Book App Store

  Background: Launch the browser
    Given Launch Browser
    When URL launch sucessfully

  Scenario: Search the keyword.
    Given Search the given keyword.
    And Total numbers of book present in page
    Then Find the book name and count the number having phrase 'Architecture Theory'.
    #Then Close the browser.
