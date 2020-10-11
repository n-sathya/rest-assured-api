Feature: Validate Place API

@AddPlace
Scenario Outline: Verify addPlaceApi using http Post

Given user has payload ready with "<address>" "<language>" "<name>" "<phone>"
When user calls "AddPlaceApi" with "post" http request
Then user gets a statuscode of "200"
And "Status" is "OK"
And "Scope" is "App"
And verify place_Id created maps to "<name>"

Examples:
|address                |language|name     |phone      |
|S101, west cross street|English |sami|512-57-8090|
#|V111, south cross street|french |Coffee House|512-576-8090|
#|Z111, east cross street|Spanish |pizza House|512-666-8070|

@DeletePlace
Scenario: Verify if deletePlaceApi using http post

Given user has deletePlaceApi payload
When user calls "DeletePlaceApi" with "post" http request
Then user gets a statuscode of "200"
And "Status" is "OK"