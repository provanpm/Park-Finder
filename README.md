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

**Given** a feed of plant data is available  

**Given** GPS details are available  

**When**  

-	Select the plant Asimina triloba  
-	Add notes: “planted by Brandan Jones”  
**Then**  when I navigate to the Specimen History view, I should see at least one Asimina triloba specimen with the notes, “planted by Brandan Jones”  

2.1  
**Given** a feed of plant data is available  
**Given** GPS details are available  
**When**   

-	Select the plant Malus domestica ‘Fuji’  
-	Take a photo of a Fuji apple seedling  
**Then** when I navigate to the Specimen History view, I should see at least one Malus domestica ‘Fuji’ specimen with the a photo of a Fuji apple seedling.  
