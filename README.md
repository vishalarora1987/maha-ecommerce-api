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

```

## Technology stack

```
SpringBoot
Java8
H2 Datastore
Karate and Cucumber
JUnit5
```

## Decisions made

```

```