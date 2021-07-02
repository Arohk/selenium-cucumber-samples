Feature: User successfully opens and plays the Zeus Ancient Fortunes game

  Background:
    Given the user logs in with "tu_assessment3" and password "Assessment@123"

  Scenario: The game opens successfully
    When the user searches for "Zeus" game and opens it
    Then the selected game should be opened successfully

  Scenario: The user plays one round and verifies the balance
    When the user's current balance is noted before playing the game
    And the user searches for "Zeus" game and opens it
    And the user plays one round
    And the user closes the game
    Then the user should have a lower balance than before playing the game