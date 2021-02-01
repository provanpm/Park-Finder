# Park Finder

---

Design Document

Paul Provan

Nicholas Pham-Rider

## Introduction

Looking for something to do outdoors? Not sure if your local green space is pet friendly? Park Finder can help

- Find all public parks within a chosen local area
- Determine outdoor activities at specific green space locations
- Congregate information about outdoor locations
- Display images of public parks before you actually go

Use your mobile device as a hub to find all the information you'll need to plan you trip to the park. Location, description, visualization and information are all features someone can utilize making their plans for the day.

## Storyboard



## Functional Requirements

### Requirement 100.0: Search for Parks

#### Scenario

As a user interested in going to the park, they should be able to search parks based on a variety of information: name, information, location  

#### Dependencies

Park search data is available and accessible.  

#### Assumptions

Desired locations are in the United States 

Park names / locations are stated in English.  

#### Examples

1.1  

**Given** a feed of park data is available  

**When**  I search for “Eden”  

**Then** I should receive at least one result with these attributes:  

Park Name: Eden Park

Location: 950 Eden Park Dr, Cincinnati, OH 45202

1.2

**Given** a feed of park data is available  

**When** I search for “Burnet”  

**Then** I should receive at least one result with these attributes:   

Park Name: Burnet Woods

Location: 3251 Brookline Ave, Cincinnati, OH 45220

1.3 

**Given** a feed of park data is available  

**When** I search for “WLIFUHskvuWHGULDS”  

**Then** I should receive zero results (an empty list)  


### Requirement 101: View Park

#### Scenario

As a user interested in going to the park, they should be able to select a specific park to view park information: name, images, activities, location, information

#### Dependencies

Park search data is available and accessible.  

#### Assumptions

Desired locations are in the United States 

Park names / locations are stated in English.  

#### Examples  

1.1

**Given** a feed of park data is available  

**When**  

-	Select the park Eden Park

**Then** I should see general park information including at least one image, an address, a description, limitations, etc. 
