# Byte Bites Restaurant

Byte Bites is a comprehensive restaurant management system designed for efficient handling of menu items, inventory, and ingredients. Built with a robust backend using Spring Boot, JPA, and PostgreSQL, the project offers an organized structure, RESTful API endpoints, and a user-friendly HTML interface for seamless data management.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [License](#license)

## Features
- **CRUD Operations**: Easily create, read, update, and delete entries for dishes, ingredients, and kitchens.
- **Dynamic SQL Execution**: Supports custom SQL commands for advanced users (with precautions to prevent accidental destructive actions).
- **REST API**: Exposes RESTful endpoints for efficient frontend-backend interaction.
- **Database Management**: Centralized PostgreSQL database for data consistency and integrity.
- **Simple UI**: An intuitive HTML-based interface to interact with the database.

## Technologies
- **Backend**: Java 21, Spring Boot, Spring Data JPA, JDBC
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Others**: JPA for ORM, Thymeleaf, RESTful API

## Project Structure
The project follows a modular structure organized into controllers, services, models, and repositories:

```
crudbytebitesrestaurant
├── controller
│   ├── DishController.java            # Handles dish-related API requests
│   ├── DishIngredientsController.java # Manages dish-ingredient relationships
│   ├── IngredientsController.java     # Handles ingredient-related API requests
│   ├── KitchenController.java         # Manages kitchen-related requests
│   └── SQLExecutorController.java     # Executes custom SQL commands (e.g., for admin users)
├── model
│   ├── Dish.java                      # Entity for dishes
│   ├── DishIngredients.java           # Entity for linking dishes and ingredients
│   ├── Ingredients.java               # Entity for ingredients
│   └── Kitchen.java                   # Entity for kitchen information
├── repository
│   ├── DishRepository.java
│   ├── DishIngredientsRepository.java
│   ├── IngredientsRepository.java
│   └── KitchenRepository.java
├── service
│   ├── DishService.java
│   ├── DishIngredientsService.java
│   ├── IngredientsService.java
│   └── KitchenService.java
├── Application.java                   # Main Spring Boot application class
└── resources
    ├── templates
    │   └── index.html                 # Frontend UI for interacting with the application
    └── application.yml                # Configuration settings for Spring Boot and PostgreSQL
```

## Getting Started

### Prerequisites
- Java 21
- Maven
- PostgreSQL

### Setup Instructions
1. **Clone the repository**:
   ```bash
   git clone https://github.com/cerobreath/crud-byte-bites-restaurant.git
   cd crud-byte-bites-restaurant
   ```

2. **Configure Database**:
   Update `application.yml` with your PostgreSQL credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/your_db_name
       username: your_username
       password: your_password
     jpa:
       hibernate:
         ddl-auto: update
   ```

3. **Build and Run the Application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the Application**:
   Visit `http://localhost:8081` to open the UI.

## Endpoints

The API provides several RESTful endpoints to manage data:

### Dish
- `GET /api/dishes`: Retrieve all dishes.
- `POST /api/dishes`: Create a new dish.
- `PUT /api/dishes/{id}`: Update an existing dish.
- `DELETE /api/dishes/{id}`: Delete a dish.

### Ingredients
- `GET /api/ingredients`: Retrieve all ingredients.
- `POST /api/ingredients`: Create a new ingredient.
- `PUT /api/ingredients/{id}`: Update an existing ingredient.
- `DELETE /api/ingredients/{id}`: Delete an ingredient.

### Kitchen
- `GET /api/kitchens`: Retrieve all kitchens.
- `POST /api/kitchens`: Add a new kitchen.
- `PUT /api/kitchens/{id}`: Update an existing kitchen.
- `DELETE /api/kitchens/{id}`: Delete a kitchen.

### Custom SQL Execution
- `POST /api/sql/execute`: Execute custom SQL commands (restricted for advanced users).

## License
This project is licensed under the MIT License.
