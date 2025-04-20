# Spring Boot H2 Sample

A comprehensive Spring Boot application demonstrating the use of H2 in-memory database with JPA, batch processing, and
Apache Kafka integration for high-performance message processing.

This project showcases how to efficiently save 100,000 student records into an H2 database using batch processing and
then publish all the saved data to a Kafka topic. The application serves as an excellent reference for implementing
batch operations and message streaming in Spring Boot applications.

## Technologies Used

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- H2 Database (in-memory)
- Apache Kafka
- Docker & Docker Compose
- Lombok
- Maven

## Features

- In-memory H2 database for fast data storage and retrieval
- Efficient batch processing of 100,000 student records
- Kafka integration for reliable message publishing
- RESTful API endpoints for data operations
- Docker Compose setup for Kafka infrastructure
- Optimized JPA configuration for batch operations

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Docker and Docker Compose (for running Kafka infrastructure)
- OR Kafka server running on localhost:9092 (if not using Docker)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/hendisantika/spring-boot-h2-sample.git
cd spring-boot-h2-sample
```

### Start Kafka Infrastructure (using Docker)

The project includes a Docker Compose file to easily set up Kafka and Zookeeper:

```bash
docker-compose up -d
```

This will start:

- Zookeeper on port 2181
- Kafka on port 9092

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

- URL: `jdbc:h2:mem:testdb?serverTimezone=UTC&cachePrepStmts=true&useServerPrepStmts=true&rewriteBatchedStatements=true`
- Driver: `org.h2.Driver`
- Username: `yu71`
- Password: `53cret`

The H2 console is enabled and can be accessed at: http://localhost:8080/h2-console

When connecting through the H2 console, use these settings:

- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `yu71`
- Password: `53cret`

## API Endpoints

### 1. Load Data into Database

```
GET /save
```

This endpoint loads 100,000 student records in batches of 1,000 into the H2 database.

**Example Response:**

```
Starting synchronous data load 2023-05-15T10:30:45.123
```

The console logs will show the start and completion times of the data loading process.

### 2. Send Data to Kafka

```
GET /send-to-kafka-broker
```

This endpoint fetches all student records from the database and sends them to a Kafka topic named "student_topic".

**Example Response:**

```
Send to kafka broker 2023-05-15T10:35:12.456
```

## Data Model

The application uses a simple `Student` entity with the following fields:

- `id`: Long (primary key, auto-generated)
- `name`: String
- `standard`: Integer
- `rollNo`: Integer

## Batch Processing

The application demonstrates efficient batch processing by:

- Using a batch size of 1,000 records
- Configuring Hibernate's batch size to match
- Optimizing JDBC parameters for batch operations
- Processing a total of 100,000 records in 100 batches

## Project Structure

- `entity`: Contains the Student JPA entity
- `repository`: Contains the StudentRepository for database operations
- `service`: Contains the LoadDataIntoDB service for batch data loading
- `controller`: Contains the StudentController with API endpoints
- `config`: Contains Kafka configuration classes and custom serializers

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

- Hendi Santika
- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Website: [s.id/hendisantika](https://s.id/hendisantika)
