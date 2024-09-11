# BrowserExtensionStore

BrowserExtensionStore is a Spring Boot-based application designed for managing and storing browser extensions. This repository provides an API to upload, store, and manage extensions along with their metadata, including version history, upload date, and the extension's link to the Chrome Web Store.

## Features
- **Upload Extensions**: Upload and store browser extensions as binary data (BLOB).
- **Manage Metadata**: Save metadata such as extension name, developer ID, version number, upload date, last modified date, and Chrome Web Store link.
- **Version Control**: Track the version of each extension to maintain history.
- **REST API**: Offers an API endpoint for developers to interact with the system and upload extensions.

## Technologies Used
- **Java**: Core programming language used for backend logic.
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring-based applications.
- **JPA (Java Persistence API)**: ORM tool used for mapping Java objects to database tables.
- **MySQL**: Relational database management system used to store extension data.
- **Maven**: Project management and build tool.

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8.x or higher
- MySQL 8.x or higher

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/BrowserExtensionStore.git
    ```
2. Configure the MySQL database connection in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/browser_extension_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    ```
3. Run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```

### API Endpoint
- **Upload Extension**:  
  Endpoint: `GET /mainController`  
  Description: Uploads an extension file and saves metadata like name, version, and browser link.

