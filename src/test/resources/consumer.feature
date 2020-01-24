Feature: consumer
  The consumer only data, convert to pojo, then update to database

  Scenario Outline: consumer

    Examples:
    1. Event is in Kafka, consume it, the event content is invalid.
    2. Event is in Kafka, consume it, fail to convert it to pojo.
    3. Event is in Kafka (String), consume it convert it to POJO, then persist to database.

Feature: parking pricing

  Scenario Outline: valid event from Kafka
    Given getting the event "{"sku_id": "2215672043486", "is_active":true,"max_qty": 24}"
    When event consumer consumes it
    Then event is persisted into database

    Examples: In the item table, we have the following structure:
      | sku_id  | is_active  | max_qty     |
      | 2215672043486   | true     |   24 |

  Scenario Outline: Invalid event from Kafka
      Given getting the event "{"sku_id": "", "is_active":true,"max_qty": 24}"
      When event consumer consumes it
      Then a ValidationException is thrown, as the mandatory params are missing in the event.


