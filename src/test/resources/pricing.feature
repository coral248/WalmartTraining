Feature: parking pricing
  As a unser I want to pay so I can go home.

  Scenario Outline: hourly pricing
    Given I entered the parking "<entry_time>"
    When I pay at "<payment_time>"
    Then payment is <amount>

    Examples: 
      | entry_time | payment_time | amount |
      | 10:00:00   | 10:00:01     |   10.0 |
      | 10:00:00   | 10:59:59     |   10.0 |
      | 10:00:00   | 11:00:00     |   20.0 |
