Feature: consumer
  The consumer only data, convert to pojo, then update to database

  Scenario Outline: consumer

    Examples:
    1. Event is in Kafka, consume it, the event content is invalid.
    2. Event is in Kafka, consume it, fail to convert it to pojo.
    3. Event is in Kafka (String), consume it convert it to POJO, then persist to database.

