# Online Pharmacy

This project provides a very small prototype of an online pharmacy application using Spring Boot. It exposes REST endpoints to browse and search example drugs and provides a simple chat interface backed by document lookup.

## Building

The project uses Maven. Run `mvn package` to build the application. Internet access is required on the first build to download dependencies.

## Running

Run the application with:

```bash
mvn spring-boot:run
```

Access the chat interface at [http://localhost:8080/index.html](http://localhost:8080/index.html).
