Feature: User successfully opens and plays the Zeus Ancient Fortunes game

  Background:
    Given the user logs in with "UserName" and default password
    When the user searches for "Zeus Ancient fortunes" game and opens it

  Scenario: The game opens successfully
    Then the selected game should be opened successfully

  Scenario: The user plays one round and verifies the balance
    When the user's current balance is noted before playing the game
    And the user plays one round
    And the user closes the game
    Then the user should have a lower balance than before playing the game