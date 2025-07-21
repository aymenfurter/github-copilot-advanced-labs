# Lab 3: Motor Insurance Application

A legacy Java web application built with Spring MVC for managing motor insurance policies. 

## Prerequisites

- Java 8 or later (yes, we're that old)
- Maven 3.6 or later (almost as old as the dinosaurs)
- A Java IDE (optional, but highly recommended unless you code like it's 1999)
- Patience (required for all legacy applications)

## Technology Stack

- Spring MVC 4.3.x (practically archaeological)
- H2 Database (because even dinosaurs needed somewhere to store their data)
- JSP/JSTL (so vintage it's almost cool again)
- JUnit/Mockito for testing (because even Jurassic code needs tests)

## Building the Application

To build the application, run:

```bash
mvn clean package
```

This will create a WAR file in the `target` directory. Yes, a WAR file. Not a JAR, not a container image. We're keeping it old school.

## Running the Application

There are several ways to run this prehistoric application:

### Using Maven

First, build the application (wait for your computer to stop making dial-up noises):
```bash
mvn clean package
```

Then run it using Tomcat7 Maven plugin (yes, Tomcat7, from when dinosaurs roamed the Earth):
```bash
mvn tomcat7:run
```

The application will be available at: `http://localhost:8080/motor-insurance/policies`

Please allow extra time for pages to load. They have to travel all the way from the Mesozoic Era.