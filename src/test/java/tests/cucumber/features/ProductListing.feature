@productListing @prod @test @search
Feature: Search section
  Background:
    Given I am on "" Home Page

  Scenario: Successfully product listing by search box on Home Page
    When I enter search input "iphone"
    Then I should verify the product images are loaded on Listing Page

