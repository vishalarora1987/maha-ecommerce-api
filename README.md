# maha-ecommerce-api
This builds an e-commerce API for Maha Coding Challenge

## Getting Started
### How to run locally
```
cd into the ecommerce directory and run following -

1. mvn clean install
2. mvn spring-boot:run (This will start the application on port 8080)

Open another terminal and run
3. mvn test -Dtest=LocalRunner -Dcucumber.options='--tags @CDC'
This will run the end to end intergation test locally and display request and response for 4 configured scenarios

A easier way is to run the contract runner using this command -
4.  mvn test -Dtest=ContractsRunner
This will start the application and run the configured scenarios.

Though mnv clean install will run the unit tests, you can explicitly use this -
5. mvn test

You can see the H2 Database contents using following link once you have started the application -
6. http://localhost:8080/h2-console (use credentials in application.properties to connect)

```

## Technology stack

```
SpringBoot
Java8
H2 Datastore
Karate and Cucumber
Mockito
JUnit4
```

## Decisions made

```

While working on this project following decisions were made -
1. How to persist the catalogue of watches
2. Which datasource to use
3. How to structure the entity classes
4. How to implement the business logic such that it is efficient and clean
5. What should be the project stucture such that it is clean, consise and scalable w.r.t. new features
6. What testing framework to use

Storing the catalogue in the right manner is the key to solving this problem in an efficient manner. I used H2 Database for this 
since a) It is embedded in memory store and doesn't need heavy lifting for this small a project and is quite fast for our use case. 
b) It maps out to entities in a way that we do not need to do a join explicitly thus making our code clean and efficient
c) H2 database provides an out of box console which can be used to view and manipulate data.

Business logic is implemented using Java Streams API to first convert the given list of watch ids into a map which stores
unique watch ids and its frequency in the given list. This structured approach makes further steps much simpler i.e. next
we simply need to iterate over entry set of the map to calculate the price for each watch and add it to out total price.
A separate method named calculatePrice first fetched the watch data from database and then uses discount information to 
either apply a discount or not (based on rules).

The project structure is made in a way that you have controllers to receive the request and pass it on to the service method calls
i.e. checkout which then calls database to fetch required data and processes and calculates the price and returns the contol back 
to the controller.

For testing I have used Karate and JUnit to have end to end integration test for the Checkout API and component testing on the 
controller and service. Karate provides a strong framework to have end to end tests/contracts which can be extended to have mocks for 
downstream or upstream services.

Many things can be improved in this namely -
1. Adding Exceptions and handling edge and error scenarios. We can have interceptors to intercept the exception raised and log it dynamically
2. Adding logging using logback etc. to have defined loggig and pass the logs to kinesis stream and use Kibana on top of it for visualisation.
3. Having a persistent data store such as MySQL if needed. 
4. Having monitoring metrics in place if we want to have monitoring and alerting

Apart from this there are a lot of things such as integrating with CI/CD for continuous integration, switching to running the application on docker
and/or having terraform scripts to deploy this on AWS Elastic Beanstalk environment or using Kubernates etc.

Thank you!
```