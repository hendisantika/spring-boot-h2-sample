# Spring Boot H2 Sample

A sample Spring Boot application demonstrating the use of H2 in-memory database with JPA and Kafka integration for
message processing.

## Technologies Used

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- H2 Database (in-memory)
- Apache Kafka
- Lombok
- Maven

## Features

- In-memory H2 database for data storage
- Batch processing of student records
- Kafka integration for message publishing
- RESTful API endpoints

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Kafka server running on localhost:9092 (for Kafka functionality)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/hendisantika/spring-boot-h2-sample.git
cd spring-boot-h2-sample
```

### Build the Application

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on port 8080.

## Database Configuration

The application uses an H2 in-memory database with the following configuration:

- URL: `jdbc:h2:mem:testdb`
- Driver: `org.h2.Driver`
- Username: `yu71`
- Password: `53cret`

The H2 console is enabled and can be accessed at: http://localhost:8080/h2-console

## API Endpoints

### 1. Load Data into Database

```
GET /save
```

This endpoint loads 100,000 student records in batches of 1,000 into the H2 database.

### 2. Send Data to Kafka

```
GET /send-to-kafka-broker
```

This endpoint fetches all student records from the database and sends them to a Kafka topic named "student_topic".

## Project Structure

- `entity`: Contains the Student JPA entity
- `repository`: Contains the StudentRepository for database operations
- `service`: Contains the LoadDataIntoDB service for data loading
- `controller`: Contains the StudentController with API endpoints
- `config`: Contains Kafka configuration classes

## Author

- Hendi Santika
- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Website: [s.id/hendisantika](https://s.id/hendisantika)
