## Instructions:
- You only have to finish up the files inside the Controller and Service folder.
- When modifying the code, navigate to the IDE's Run tab and click on the BUILD button to compile the project.
- Check the terminal logs for any code or build errors.
- The MySQL environment can be accessed through the terminal.
- To start the server, go to the IDE's Run tab and click on the "Start Server" button. You can monitor the progress in the terminal logs.
- Once the server is started, navigate to the Thunder Client's tab  ![Thunder client's tab](https://github.com/sumati95/ThunderClient/blob/main/Screenshot%20from%202024-02-01%2014-12-22.png?raw=true) and make a new request.
- Test the API endpoints by visiting http://localhost:8000/{endpoints}. You can view the JSON response in the "Response" tab.
- Thoroughly test your APIs before clicking the SUBMIT button in the IDE.

## Problem Description

Implement REST APIs to list the names of the teams who won in the IPL Cricket match and who played in 2013.

Each event is a JSON entry with the following keys:

- **teamId** : the unique ID of the team(Integer)
- **teamName** : the name of the team(String)
- **runs** : the runs made by the team(Integer)
- **targetRuns** : the target runs they have to make(Integer)
- **year** : the year in which the team played (Integer)

Here is an example of a Team JSON object:

```
[
    {
        "teamId": 1,
        "teamName": "RR",
        "runs": 185,
        "targetRuns": 170,
        "year": 2011
    },
    {
        "teamId": 2,
        "teamName": "KKR",
        "runs": 125,
        "targetRuns": 190,
        "year": 2013
    },
    {
        "teamId": 3,
        "teamName": "RCB",
        "runs": 195,
        "targetRuns": 180,
        "year": 2013
    }

]
```
You are provided with the implementation of the models required for all the APIs. Your task is to implement a set of REST services that exposes the endpoints and allows for listing all the team details who won in the IPL match and getting the list of the teams who played in 2013.

**Task-1: GET request to /winning_teams**

- Filter out the teams that have a number of runs greater than or equal to their target runs.
- If no winning teams are found, return a response with HTTP status 404 (NOT_FOUND); otherwise, return a response with the winning teams and HTTP status 200 (OK).

**Task-2: GET request to /team_2013**

- Filter out the teams that belong to the year 2013.
- If no teams are found for the year 2013, return a response with HTTP status 404 (NOT_FOUND); otherwise, return a response with the teams from 2013 and HTTP status 200 (OK).

Complete the given project to pass all the test cases when running the provided unit tests. Files in which you need to write the code:

**1) teams/controller/TeamsController.java**

- Implement the @GetMapping API here

**2) teams/service/TeamsService.java**

- Implement the GET method, which should list all the teams' details.

**Example requests and responses**

*GET request to /winning_teams*

The response code is 200, and the response body, when converted to JSON, is as follows:

```
[
    {
        "teamId": 1,
        "teamName": "RR",
        "runs": 185,
        "targetRuns": 170,
        "year": 2011
    },
    	     {
        "teamId": 3,
        "teamName": "RCB",
        "runs": 195,
        "targetRuns": 180,
        "year": 2013
    }
]
```
*GET request to /team_2013*

The response code is 200, and the response body, when converted to JSON, is as follows:

```
[
    {
        "teamId": 2,
        "teamName": "KKR",
        "runs": 125,
        "targetRuns": 190,
        "year": 2013
    },
    {
        "teamId": 3,
        "teamName": "RCB",
        "runs": 195,
        "targetRuns": 180,
        "year": 2013
    }
]
```


