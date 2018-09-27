# ebanking
Online Banking Project

This is an online banking project by Cemil Aydogdu.
https://github.com/caydogdu/ebanking

These are the main abilities of project

    Ability to create monetary accounts with initial balance
    Ability to transfer money from one account to another

This project was developed with spring boot. Java 8 is required. Accounts stored in memory, no database was used.

There are 2 REST Service in this project.

To open an account

    POST localhost:8081/accounts with body
    {
        "name":"burcu",
        "balance":70
    }

To transfer from one account to another
    
    POST localhost:8081/transfers with body
    {
        "nameFrom":"cemil",
        "nameTo":"burcu",
        "amount":50
    }

You can also find sample requests in the sample-requests.pdf

## Run options and deployment

This project is a microservice. So you can easily run it.

1- Running as a packaged application
If you use the Spring Boot Maven or Gradle plugins first create an executable jar then you can run your application using java -jar. For example:

    $ java -jar target/ebanking-0.0.1-SNAPSHOT.jar

It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:

2- Using the Maven plugin
The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.

    $ mvn spring-boot:run

