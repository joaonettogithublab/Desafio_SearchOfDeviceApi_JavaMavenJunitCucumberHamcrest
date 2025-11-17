
Feature: Search Specific Device by identification

  @SmokeTest
  Scenario Outline: Validate enable Api of Specif device information

    Given I send the parameter for identification of device "<identificationDevice>"
    When  I access the endpoint List of objects by id
    Then  I receive the json response with status code success "<successReturnCode>"


    Examples:
      | identificationDevice | successReturnCode   |
      | 1                    | success             |
      | 3                    | success             |
