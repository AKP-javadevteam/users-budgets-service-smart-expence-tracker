# Users & Budgets Service — Smart Expense Project

This is the **Users & Budgets Service** for the Smart Expense project.  
It manages **user profiles**, **default currency settings**, and **monthly budgets per category**.  
Other microservices consume this data for personalization and financial insights.

---
## 📂 Current State (MVP foundation)

- ✅ **Database migration (Flyway)** with `users` and `budgets` tables.
- ✅ **JPA entities**: `User`, `Budget`.
- ✅ **Repositories**: `UserRepository`, `BudgetRepository`.
- ✅ **DTOs** for budget request/response payloads.
- 🔜 **Service layer** for handling budget creation & queries.
- 🔜 **Controllers**:
    - `GET /budgets?month=YYYY-MM`
    - `POST /budgets`
    - `GET /internal/budgets-by-user/{userId}?month=YYYY-MM`
- 🔜 **JWT-based security** (Spring Security Resource Server).
- 🔜 **OpenAPI/Swagger** documentation.
- 🔜 **Actuator health/info** endpoints.


---

## 🚀 Tech Stack

- **Project**: Maven, Java 17
- **Spring Boot**: 3.5.4

### Dependencies
- **Spring Web** — REST controllers for user and budget management.
- **Spring Security** — JWT-based resource server for authorization.
- **Spring Data JPA** — persistence layer for users and budgets.
- **PostgreSQL Driver** — relational database for storing profiles and budgets.
- **Flyway** — database migration and versioning.
- **Validation** — request payload validation using annotations.
- **Spring Boot Actuator** — monitoring and health checks.


---

## 📂 Project Purpose
- Manage **user profile data** (name, email, preferences).
- Store and expose **default currency** per user.
- Allow users to define **monthly budgets by category**.
- Provide APIs for other services to fetch and update user/budget data.
- Secure all endpoints with **JWT validation**.
- Enable health monitoring via Actuator.

---
