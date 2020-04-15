
# api-project

This project demonstrates how to build a Spring boot application that exposes an API to get citizen list filtered by fiscal code.

This project uses:

- Spring boot
- JPA
- Maven

You can refer to the OpenAPI file that describes the API interface.

## API invocation
To invoke the API the URL is:

    http://localhost:8080/api/v1/dati?codice-fiscale=<fiscal-code>&limit=<limit>&offset=<offset>

where *limit* is the number of items to return and *offset* is the starting point.
