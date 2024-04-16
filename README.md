# TalentReef Java API Back End challenge

## Description

This [Spring Boot](https://spring.io/projects/spring-boot) project has been modified from the original template to fulfill the conditions requested in the challenge's document. The code can be executed in the same manner as the original template and the HTTP requests can be easily tested with tools such as [Postman](https://www.postman.com) - Examples are provided 

## Requirements

Java 17 -- Java can be acquired using [SDKMAN!](https://sdkman.io/)

## Running the Application

Start the server using Gradle:

```shell
./gradlew bootRun
```

See [Running your Application with Gradle](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#running-your-application) for more information.

Execute tests using Gradle:

```shell
./gradlew test
```

## Testing with Postman

### 1) An initial POST should be made to fill the system
``` 
POST http://localhost:9000/v1/widgets

Raw JSON data:
[
    {
        "name": "Clock",
        "description": "Basic clock display",
        "price": 10.12
    },
    {
        "name": "Weather",
        "description": "Displays the current weather for your location",
        "price": 25.22
    },
    {
        "name": "News",
        "description": "Get the latest news!",
        "price": 35.21
    }
]
``` 

### 2) A simple get to verify the data
``` 
GET http://localhost:9000/v1/widgets
``` 


### 3) Obtain the info of a Widget given it's name
``` 
GET http://localhost:9000/v1/widgets/Clock
``` 

### 4) Obtain only the description or price of a Widget given it's description or price
``` 
GET http://localhost:9000/v1/widgets/Clock/description
GET http://localhost:9000/v1/widgets/Clock/price
``` 

### 5) Delete a Widget given it's name
``` 
DELETE http://localhost:9000/v1/widgets/Clock
``` 

### 6) Update a Widget's description given it's name and a new Description
``` 
PUT http://localhost:9000/v1/widgets/Weather/description

Raw JSON data:
{
  "newDescription": "This is a new Description!"
}
``` 

### 7) Update a Widget's price given it's name and a new price
``` 
PUT http://localhost:9000/v1/widgets/Weather/price

Raw JSON data:
{
  "newPrice": 12.34
}
``` 

## Additional Information

Template provided by TalentReef, challenge solution provided by Jhodad Gomez.
