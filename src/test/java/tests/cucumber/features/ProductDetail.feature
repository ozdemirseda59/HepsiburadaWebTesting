@productDetail @prod @test
Feature: Product Detail section
  Background: Successfully go to any product detail
    Given I am on "" Home Page

  Scenario: Successfully go to product detail page
    When  I enter search input "iphone"
    And   I click on any product
    Then  I should see Product Detail Page

   Scenario: Successfully like comment
     When  I enter search input "iphone"
     And   I click on any product
     Then  I should see Product Detail Page
     When I click reviews tab
     And  I click yes like icon
     Then I should see thanks text
