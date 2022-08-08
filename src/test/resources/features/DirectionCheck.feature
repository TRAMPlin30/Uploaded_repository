@smoke

Feature: Manipulations with system user interface elements in tests

  Scenario Outline: Validate distance from point A to point B

    When Launch OpenStreetMap application in Chrome browser
    And Click on the button directions
    And Enter name of point A in the field <from>
    And Enter name of point B in the field <to>
    And In the transport option dropdown list select <transport>
    And Click on the button Go
    Then Make sure the distance matches <distance>

    Examples:
      | from             | to         | transport               | distance |
      | "Радищева, Київ" | "Кембрідж" | "Bicycle (OSRM)"        | 2425     |
      | "Кременчуг"      | "Кембрідж" | "Bicycle (GraphHopper)" | 2879     |
      | "Полтава"        | "Кембрідж" | "Car (GraphHopper)"     | 2825     |
      | "Харьков"        | "Кембрідж" | "Car (OSRM)"            | 2993     |
      | "Винница"        | "Кембрідж" | "Foot (GraphHopper)"    | 2298     |
      | "Львов"          | "Кембрідж" | "Foot (OSRM)"           | 1960     |








