<img src="./.github/logo.png" align="right" height="150" width="150">

# Product Catalogue - POC

## Overview

The Product Catalogue application is a proof of concept (POC) for managing a product catalog. It provides functionalities for adding, searching, and retrieving products using a fuzzy search algorithm.

## Features

- Add new products to the catalog
- Retrieve all products
- Search for products using a fuzzy search algorithm
- Exception handling for common scenarios

## Technologies Used

- Java
- Spring Boot
- Maven
- JUnit 5

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/avinashsingh1712/productCatalog.git
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### Configuration

The application can be configured using the `application.properties` file located in the `src/main/resources` directory. Here is an example configuration:'

```ini
spring.application.name=product-catalog
```
### Test
All the below Curl commands are added in the Postman collection in the below link. Please save the file and import in your Postman.
https://github.com/avinashsingh1712/productCatalog/blob/ReadMe-update/src/test/Product-catalog.postman_collection.json


