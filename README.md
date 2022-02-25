Step 1:
Call get personal details API

http://localhost:8080/api/personal-details

payload :
{
    "age": 30,
    "birthdate": "12/30/1984",
    "homeCountry": "USA"
}

Step 2:
Call create nba-action-figure api

http://localhost:8080/api/nba-action-figure

payload :
{
    "playerName": "Lebron James",
    "team": "Los Angeles Lakers",
    "jerseyNumber": "23",
    "personalDetails": {
        "age": 30,
        "birthdate": "12/30/1984",
        "homeCountry": "USA"
    }
}
    
