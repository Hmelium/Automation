Feature: Is Quarantine over already?
  Everybody wants to know when quarantine is over

  Scenario Outline: Is it over?
    Given number of ill people is <number>
    When I ask whether it's quarantine is over
    Then I should be told '<answer>'
    Examples:
      | number | answer                  |
      | 1200   | Quarantine is going on! |
      | 10     | Quarantine is over!     |

  Scenario: Can i go to cinema?
    Given quarantine is over
    When I ask whether i can go to cinema
    Then I should be told 'Yes, you can!'
