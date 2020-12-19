Feature: Hong Kong Observatory API - Get 9-day forecast

  Scenario:  Get relative humidity of the day after tomorrow
    Given a Hong Kong Observatory API
    When get 9 day weather forecast
    Then extract relative humidity for the day after tomorrow

