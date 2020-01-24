Feature: event consumer

  Scenario Outline: valid event from Kafka
    Given getting the event
    When event consumer consumes it
    Then event is persisted into database "2215672043486|true|24"

    Examples: In the item table, we have the following structure:
      | sku_id  | is_active  | max_qty     |
      | 2215672043486   | true     |   24  |

  Scenario Outline: Invalid event from Kafka
      Given getting the event
      When event consumer consumes it
      Then a ValidationException is thrown, as the mandatory params are missing in the event.

    Examples: If the input structure is:
      | sku_id  | is_active  | max_qty     |
      |     | true           |   24 |


