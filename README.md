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

![Storyboard](https://github.com/phamrina/Park-Finder/blob/main/phone.PNG)

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

## Class Diagram

![ClassDiagram](https://github.com/phamrina/Park-Finder/blob/main/Class%20Diagram%20(parkfinder).png)

### Class Diagram Description

**MainActivity:** The first screen the user sees. This will have a list of parks, and an option to search for a different park. 

**ParkDetailsActivity:** A screen that shows details of a park. 

**RetrofitInstance:** Boostrap class required for Retrofit. 

**Park:** Noun class that represents a park. 

**Activities:** Noun class that represents various activities in a park. 

**IParkDAO:** Interface for Retrofit to find and parse Park JSON. 

**IActivitiesDAO:** Interface for Room to persist activity data per park. 


## Scrum Roles

- DevOps/Product Owner/Scrum Master: Paul Provan
- Frontend Developer / Integration Developer: Nicholas Pham-Rider

## Weekly Meeting

Sunday at 7 PM.  Use this Teams:

Meeting Information
[Office Hours Teams](https://teams.microsoft.com/l/meetup-join/19%3ameeting_NzYwYzQ3ZGEtNDkzNS00ZTU4LWEzYWItY2UwNzM3YzZkMzJh%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%225e43e7e5-c6e8-44a8-8867-fdf93cf9d11c%22%7d)
