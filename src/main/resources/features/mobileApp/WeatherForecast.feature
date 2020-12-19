Feature: MyObservatory Android App

  Scenario: Check tomorrow weather forecast from 9-day forecast screen
    Given MyObservatory is installed and launched in Android Emulator
    And agree the agreement
    And close reminder dialog
    When access to 9-Day Forecast
    Then get tomorrow weather forecast



