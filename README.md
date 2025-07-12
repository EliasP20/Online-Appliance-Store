
🛒 Online Appliance Store – Spring Boot Microservices Project

This project is a backend implementation of an online appliance store built using Spring Boot microservices architecture, containerized with Docker, and registered via Eureka service discovery. It includes independent services for managing products, shopping carts, and sales, all connected through an API Gateway.

🧱 Architecture Overview
- Eureka Server – Service discovery registry.
- API Gateway – Central entry point to route requests to the correct microservice.
- Products Service – Manages appliance product data.
- Shopping Carts Service – Handles users' cart operations.
- Sells Service – Registers and manages sales or purchases.
- MySQL – Relational database used by all services.
- Docker Compose – Orchestrates all services locally in containers.

🚀 Technologies Used
- Java 17
- Spring Boot
- Spring Cloud Gateway
- Spring Data JPA
- Eureka Discovery Server
- MySQL
- Docker & Docker Compose
- Maven

⚙️ Running the Project Locally

Prerequisites:
- Docker & Docker Compose
- Java 17
- Maven

Steps:
1. Package all services:
   mvn clean package -DskipTests

2. Build and run the containers:
   docker-compose up --build

3. Access services:
   - Eureka: http://localhost:8761
   - Gateway: http://localhost:8080
   - Products API: http://localhost:8080/products-service/...
   - Shopping Carts API: http://localhost:8080/shopping-cars-service/...
   - Sells API: http://localhost:8080/sells-service/...

📁 Project Structure
/api-gateway
/products-service
/shopping-cars-service
/sells-service
/eureka-serv
/docker-compose.yml

📌 Notes
- All environment-specific variables are defined through application.properties using ${ENV_VARIABLE} placeholders.
- Docker Compose injects the correct values at runtime.
- Default MySQL credentials are for development only.

👨‍💻 Author
Elias Perozo Rojas
Spring Boot Developer | Computer Science Student

📜 License
This project is for educational purposes. Feel free to fork and build on it!
