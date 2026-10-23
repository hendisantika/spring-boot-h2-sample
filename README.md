# Spring Boot H2 Sample

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-h2-sample/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-h2-sample/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot)
![Dependabot](https://img.shields.io/badge/Dependabot-enabled-025E8C?logo=dependabot)

A comprehensive Spring Boot application demonstrating the use of H2 in-memory database with JPA, batch processing, and
Apache Kafka integration for high-performance message processing.

This project showcases how to efficiently save 100,000 student records into an H2 database using batch processing and
then publish all the saved data to a Kafka topic. The application serves as an excellent reference for implementing
batch operations and message streaming in Spring Boot applications.

## Technologies Used

- Java 25
- Spring Boot 4.1.1
- Spring Data JPA
- H2 Database (in-memory)
- Apache Kafka (Spring for Apache Kafka, kafka-clients 4.4.0)
- Jackson 3 (`tools.jackson`) for JSON serialization of Kafka messages
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

- Java 25 or higher (e.g. [Eclipse Temurin 25](https://adoptium.net/))
- Maven 3.9 or higher (or use the bundled Maven Wrapper `./mvnw`)
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
docker compose up -d
```

> **Note:** The project includes `spring-boot-docker-compose`, so running the application with `./mvnw spring-boot:run`
> will automatically start the services in `compose.yml` if Docker is available.

This will start:

- Zookeeper on port 2181
- Kafka on port 9092

### Build the Application

```bash
./mvnw clean install
```

### Run the Application

```bash
./mvnw spring-boot:run
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

## Continuous Integration

The [Java CI with Maven](.github/workflows/maven.yml) GitHub Actions workflow runs on every push and pull request to
`main` (and can be triggered manually):

- Sets up Temurin JDK 25 with Maven dependency caching
- Builds and tests the project with `mvn -B package`
- Submits the Maven dependency graph to GitHub (pushes to `main` only) to improve Dependabot alerts

## Dependency Management

[Dependabot](.github/dependabot.yml) keeps dependencies up to date:

| Ecosystem      | Schedule                    | Notes                                                                            |
|----------------|-----------------------------|----------------------------------------------------------------------------------|
| Maven          | Daily, 05:00 Asia/Jakarta   | Grouped: Spring, Kafka, and other minor/patch updates                            |
| GitHub Actions | Daily, 05:00 Asia/Jakarta   | All action updates grouped into a single PR                                      |
| Docker Compose | Weekly (Monday), 05:00 WIB  | Images in `compose.yml`; Confluent major updates ignored (8.x drops ZooKeeper)   |

Pull requests are labeled and use Conventional Commit prefixes (`build(deps)`, `ci(deps)`, `build(docker)`).

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
