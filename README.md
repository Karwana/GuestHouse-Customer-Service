# GuestHouse Customer Service

A backend microservice built with Spring Boot and Docker, designed to handle customer management for the GuestHouse system.

## Microservices
This service operates independently with its own database (`customerservice`) and exposes a REST API. It connects with the **Booking Service** to check for active bookings before allowing customer deletions.

## Features
* **Customer Management:** Full REST API endpoints for creating, reading, updating, and deleting customers.
* **Input Validation:** Built-in validation ensuring required fields, valid email addresses, and phone numbers.
* **Cross-Service Protection:** Verifies with the Booking Service that a customer has no active bookings before deletion is permitted.

## Tech Stack
* Java 21
* Spring Boot 4.0.6
* Spring Data JPA & Hibernate
* MySQL
* Docker

## Repository Structure Note for Docker Compose
For `docker compose up --build` to locate all service directories correctly using the relative build contexts, ensure that all three repositories (`GuestHouse-Booking-System`, `GuestHouse-Customer-Service`, `GuestHouse-Review-Service`) and your infrastructure repository (`GuestHouse-Infrastructure`) are placed within the same parent folder like this:

```text
📁 parent-folder/
├── 📁 GuestHouse-Infrastructure/  (contains docker-compose.yml)
├── 📁 GuestHouse-Booking-System/
├── 📁 GuestHouse-Customer-Service/
└── 📁 GuestHouse-Review-Service/
