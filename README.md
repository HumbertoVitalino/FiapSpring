# SpringContacts

SpringContacts is a contact management system built using the Spring Framework. It allows users to manage their contact information efficiently with a focus on clean architecture and scalability.

---

## Features

- **Contact Management**: Add, update, delete, and view contacts.
- **RESTful API**: Built with Spring Boot to offer a smooth API experience for integration.
- **Database Integration**: Supports relational databases using PLSQL.
- **Lightweight Docker Support**: Includes a `Dockerfile` for containerized deployment.

---

## Tech Stack

- **Java (Spring Framework)**: Core backend development.
- **PLSQL**: Database integrations.
- **Docker**: Containerization for easy deployment.

---

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8 or higher
- Docker (optional, for containerized deployments)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HumbertoVitalino/SpringContacts.git
   cd SpringContacts

2. Build the project:
    ```bash
    mvn clean install
    
3. Run the application:
    ```bash
    mvn spring-boot:run

4. Access the application at http://localhost:8080.

---

### Docker Deployment

1. Build the Docker image:
   ```bash
   docker build -t springcontacts .

2. Run the container:
    ```bash
    docker run -p 8080:8080 springcontacts

---

## Contributing
Contributions are welcome! Feel free to submit a pull request or open an issue to discuss improvements.




