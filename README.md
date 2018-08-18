# VDELLANGELA - Swipejobs Technical assessment

The purpose of this application is to return the top 3 recommended jobs for a worker based on his details


## Setup

Requirements are having Java and Maven installed.
Run the below command to download all the dependencies and generate a jar:
```
maven clean install
```
And run this command to start the application:
```
java -jar target/swipejobs-0.0.1-SNAPSHOT.jar
```

The application provides a REST API GET http://localhost:8080/worker/{workerId} that given a worker id, will return 3 recommended jobs for this worker.


## Explanation of the code

The main part of the application is the JobServices class.
This service consists of a list of Predicates that acts like criterias based on a worker details.
These criterias are:
- Does the job require a driving license?
- Is the distance to the job acceptable by the worker?
- Does the worker has all the certificates required for the job?
- Can the worker starts on the same day as the job?
- Does any of the worker's skills appears in a job title?

Then for each jobs, I calculate how many criterias match and return the top 3 jobs that match the most criterias.

## Testing

You can run the command line mvn test in order to run the junit tests.
