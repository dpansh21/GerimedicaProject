@SearchTest @SearchFullRegression
Feature: Test Search Functionality for website of Van Gogh Museum.
    
    @VerifyCollectionPage @Priority1 @SmokeTest
	Scenario: 01. User wants to verify the collection page
    Given User launch given museum website
    When click on Ontdek de collective link
    Then Verify the collection page
  	
  	@SearchPainting 
  	Scenario: 02. User wants to Search the painting with given title
    Given User launch given museum website
    When click on Ontdek de collective link
    Then Search the painting from search box
    | PaintingName |
    | Het Gele Huis |
    And Verify the search results
    
    @VerifyFirstPainting 
  	Scenario: 02. User wants to verify the given painting
    Given User launch given museum website
    When click on Ontdek de collective link
    Then Search the painting from search box
    | PaintingName |
    | Het Gele Huis |
    Then Select First Result
    And Verify the painting
    | FNumber | JHNumber | InvNumber |
    | F0464  | JH1589 | s0032V1962 |

  