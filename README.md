# Simple Workout application
***

This repo consists code for Simple Workout Web Application. It is a part of 
my ISA (Internet Service Architecture) Course.

The backend part of the app is build with Java Spring framework.


## Service Architecture
```mermaid
flowchart TD
    workout_microservice["Workout Microservice
        Java Spring
    "]

    exercise_microservice["Exercise Microservice
        Java Spring
    "]

    workout_db[(Workout DB
        Postgresql)]

    exercise_db[(Exercise DB
                Postgres)]

    workout_microservice --> workout_db
    exercise_microservice --> exercise_db

    api_gateway[ API Gateway
        Spring Cloud
    ]

    api_gateway --> workout_microservice
    api_gateway --> exercise_microservice

    nginx[React App + Reverse proxy
        nginx]
    
    nginx --> api_gateway

```

## Running it localy
The application is containerized using **Docker**. 
Here is instruction how to run it:

1. Create your ```.env``` file using prepared example ```.env.
example```
2. Run docker composition
```bash
docker compose up
```
3. Open http://localhost:8080 in the browser to view the app
