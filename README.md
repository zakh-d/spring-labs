# Simple Workout application
***

This repo consists code for Simple Workout Web Application. It is a part of 
my ISA (Internet Service Architecture) Course.

The backend part of the app is build with Java Spring framework.


## Service Architecture
| Click on component to open it in the source code
```mermaid
flowchart TD
    workout_microservice@{shape: procs, label: "Workout Microservice
        Java Spring
    "}

    exercise_microservice@{shape: procs, label: "Exercise Microservice
        Java Spring
    "}

    discovery_service["Discovery Service
        Consul
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

    workout_microservice --> discovery_service
    api_gateway --> discovery_service
    exercise_microservice --> discovery_service

    api_gateway -.-> exercise_microservice
    api_gateway -.-> workout_microservice

    workout_microservice -.-> exercise_microservice

    nginx[React App + Reverse proxy
        nginx]
    
    nginx --> api_gateway


    click nginx "https://github.com/zakh-d/spring-labs/blob/main/frontend"
    click workout_microservice "https://github.com/zakh-d/spring-labs/blob/main/workout-microservice"
    click exercise_microservice "https://github.com/zakh-d/spring-labs/blob/main/exercise-microservice"
    click api_gateway "https://github.com/zakh-d/spring-labs/blob/main/gateway"
    click discovery_service "https://github.com/zakh-d/spring-labs/blob/main/docker-compose.yml"

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
