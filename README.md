
# Book Haul
## Description

This is a Spring Boot application for managing a book library. It provides RESTful endpoints to perform CRUD operations on books and authors, as well as manage book rentals. The application uses MySQL database for data storage.

## SetUp

### Prerequisites
- Java JDK
- MySQL
- Maven

## Dependencies

The project uses the following dependencies:

- [Spring Boot](https://spring.io/projects/spring-boot): Provides the framework for building Spring-based applications.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Simplifies the implementation of JPA-based data access layers.
- [Spring Web](https://spring.io/projects/spring-framework): Provides features for building web applications with Spring MVC.
- [Lombok](https://projectlombok.org/): Provides annotations to reduce boilerplate code in Java classes.

## Endpoints

### Authors

- **Get all authors**:
  ```http
  GET /authors/


- **Create a new author**:
  ```http
  POST /authors/
  Content-Type: application/json

  {
    "name": "John Doe",
    "biography": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
  }
  
- **Update author by ID:**:
  ```http
  PUT /authors/{id}
  Content-Type: application/json

  {
    "name": "Jane Smith",
    "biography": "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
  }
- **Get author by ID**:
  ```http
  GET /authors/{id}
- **Delete author by ID**:
  ```http
  DELETE /authors/{id}


### Books

- **Get all books:**:
  ```http
  GET /books/


- **Create a new book**:
  ```http
  POST /books/
  Content-Type: application/json

  {
    "title": "Sample Book",
    "isbn": "1234567890",
    "publicationYear": 2022,
    "author": {
        "id": 1
    }
   }
  
- **Update book by ID:**:
  ```http
  PUT /books/{id}

  Content-Type: application/json
  {
     "title": "Updated Book Title",
     "isbn": "0987654321",
     "publicationYear": 2023,
     "author": {
        "id": 1
     }
  }
- **Get book by ID:**:
  ```http
  GET /books/{id}
- **Delete book by ID**:
  ```http
  DELETE /books/{id}


### Rentals

- **Get all rentals**:
  ```http
  GET /rentals/


- **Rent a book:**
  ```http
  
  POST /rentals/renting
  Content-Type: application/json
  {
    "bookId": 1
  }
  
- **Return a rented book:**
  ```http
  GET /rentals/returning/{id}
- **Get rental by ID:**:
  ```http
  GET /rentals/{id}
- **Update rental by ID:**:
  ```http
  PUT /rentals/{id}
  Content-Type: application/json

  {
    "bookId": 2,
    "renterName": "Jane Doe"
  }
- **Delete rental by ID:**:
  ```http
  DELETE /rentals/{id}

## Testing

The project includes unit tests and integration tests to verify the functionality of the endpoints and core business logic. 

## Error Handling and Validation
The application handles errors gracefully and provides appropriate error messages for invalid requests or input data.
