# Spring Framework Shop Application

## Overview  
This application is a Spring-based web application demonstrating the use of Spring modules, HTTP protocols, and sorting algorithms, with deployment on an Apache Tomcat server. It is built using **Spring Framework**, **JDBC**, and **MVC architecture**, showcasing CRUD operations, sorting algorithms, and RESTful API design.

---

## Features  

### 1. HTTP Protocols & Apache Tomcat Web Server
- Configured and deployed the application on **Apache Tomcat**.
- Ensured proper handling of HTTP requests and responses for RESTful operations.

### 2. API Design
- Designed a RESTful API adhering to best practices for CRUD operations.
- Implemented endpoints for customer management, with routes to create, read, update, and delete customers.

### 3. Spring Framework
- Utilized core Spring modules for development:
  - **Dependency Injection (DI):** Implemented using Spring's IoC container.
  - **Autowiring:** Automatically resolved dependencies within components.
  - **Application Context:** Configured Spring beans and managed their lifecycle.
- Developed a clean MVC architecture for the application.

### 4. Sorting Algorithms
- Implemented multiple sorting algorithms: **Merge Sort**, **Quick Sort**, **Heap Sort**, **Radix Sort**, and **Bucket Sort**.
- Integrated an interface to allow users to:
  - Input numbers separated by commas.
  - Select a sorting algorithm.
  - Choose the sorting order (**Ascending** or **Descending**).

### 5. Shop Entities
- **Entities Created:**
  - **Product**
  - **Customer**
  - **Order**
- Current functionality is focused on **Customer** CRUD operations. Future updates will include CRUD for Product and Order entities.

---

## API Endpoints  

### Customer Endpoints
| Action         | HTTP Method | URL                                  | Request Body       |
|----------------|-------------|--------------------------------------|--------------------|
| Get All        | GET         | `http://localhost:8081/springProject/customer/` | N/A                |
| Delete         | DELETE      | `http://localhost:8081/springProject/customer/{id}` | N/A |
| Update         | PUT         | `http://localhost:8081/springProject/customer/{id}` | `name`, `email`    |
| Save (Create)  | POST        | `http://localhost:8081/springProject/customer/` | `name`, `email`    |

### Sort Endpoint
| Action                | HTTP Method | URL                                  | Request Body                                       |
|-----------------------|-------------|--------------------------------------|--------------------------------------------------|
| Perform Sorting       | POST        | `http://localhost:8081/springProject/sort/` | `algorithm` (e.g., "merge"), `array` (comma-separated), `order` ("asc"/"desc") |

---

## Usage  

### 1. Customer Management  
Use the provided endpoints to create, read, update, or delete customer records.  

- Example:  
  Create a customer with `POST`:  
  ```json
  {
    "name": "John Doe",
    "email": "johndoe@example.com"
  }
