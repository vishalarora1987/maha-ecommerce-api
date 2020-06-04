Feature:

  Background:
    * url baseUrl
    * configure report = true

  @CDC
  Scenario Outline: Checkout a purchase for watches
    Given path '/checkout'
    Given request
    """
    <watchIds>
    """
    When method POST
    Then status 200
    And match response ==
    """
    {
        "price": <price>
    }
    """

    Examples:
      | watchIds                                         | price        |
      | ["001", "002"]                                   | 180          |
      | ["001", "002", "001","004","003", "001", "001"]  | 460          |
      | ["001", "002", "001","004","003"]                | 360          |
      | ["001", "002", "001","004","003", "001"]         | 360          |
