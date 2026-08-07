# 🧓💰 ElderCare-Invest

### Invest Early. Age Gracefully. Retire Prepared.

**ElderCare-Invest (ElderNest)** is an educational full-stack platform designed to help individuals financially prepare for their future elder care through long-term investment planning, facility discovery, room booking, and related care services.

---

## 🚧 Current Status

ElderNest is currently in the **backend development phase**.

The project has moved beyond initial planning and now includes a working Spring Boot backend connected to a MySQL database with several REST CRUD modules implemented.

### ✅ Completed

#### Planning & Documentation

- Repository structure
- Project vision and business model
- Problem statement
- Stakeholder analysis
- Objectives
- Functional requirements
- Non-functional requirements
- User stories
- Use case documentation
- API planning
- Database design
- Architecture planning
- Development roadmap

#### UML & System Design

- Use Case Diagram
- Activity Diagrams
- Sequence Diagrams
- Class Diagram
- Domain Model
- ER Diagram
- Component Diagram
- Deployment Diagram
- Package Diagram
- State Diagrams

#### Backend Foundation

- Spring Boot backend initialized
- Java 21 configured
- Maven configured
- Layered backend architecture
- MySQL database integration
- Spring Data JPA integration
- Hibernate ORM
- REST API structure
- Global exception handling
- API response structure
- Development profile configuration
- Swagger / OpenAPI integration
- Health-check endpoint
- Environment-based database credentials

#### Implemented Backend Modules

- User CRUD
- Investor CRUD
- Investment Plan CRUD
- Investment CRUD
- Facility CRUD
- Room CRUD
- Booking CRUD
- Facility Service CRUD

#### Implemented Relationships

- User → Investor
- Investor → Investment
- InvestmentPlan → Investment
- Facility → Room
- Facility → Booking
- Room → Booking
- Facility → Facility Service

Request DTOs are being introduced for APIs involving entity relationships to avoid directly exposing or constructing incomplete JPA entities.

---

## 🚀 Currently Working On

- Completing remaining JPA entities
- Entity relationship implementation
- Request/response DTO architecture
- REST API development
- Backend validation
- Exception handling improvements
- Authentication and authorization
- Testing backend modules

---

## 📋 Next Milestones

- Complete remaining ERD entities
- KYC Verification module
- Contribution module
- Payment module
- Booking Service module
- Notification module
- Insurance Policy module
- Administrator module
- Facility Manager module
- Report module
- Spring Security
- JWT authentication
- Role-based authorization
- Backend testing
- Frontend development
- Backend/frontend integration

---

# 📖 About the Project

ElderCare-Invest addresses the problem of people waiting until retirement or a health crisis before financially preparing for elder care.

The platform explores a model where individuals can begin planning and investing for future care earlier in life.

The long-term goal is to connect:

```text
Financial Planning
        +
Long-Term Investment
        +
Elder Care Facilities
        +
Care Services
        +
Insurance
        +
Payments
```

through one integrated platform.

---

## ❗ Problem Statement

- 🏥 Quality elder care and assisted living can become expensive when the need suddenly arises.
- 📉 Many people do not financially prepare specifically for elder care early in life.
- 🧩 Financial planning and elder care services are often managed separately.
- 🌐 Families may have difficulty comparing facilities, services, and associated costs.
- 📊 Individuals may have limited visibility into how current financial planning could support future care needs.

---

## 💡 Solution Overview

ElderCare-Invest aims to provide a platform where users can:

1. Create and manage their profile.
2. Explore long-term elder-care investment plans.
3. Create and monitor investments.
4. Make scheduled contributions.
5. Browse elder care facilities.
6. View rooms and facility services.
7. Reserve rooms through the booking system.
8. Add care services to bookings.
9. Manage payments.
10. Manage insurance policies.
11. Receive notifications.
12. Access reports related to investments and care planning.

---

## 🌍 Vision

> To make quality elder care a plannable and financially prepared outcome rather than an unexpected financial emergency.

Long term, ElderCare-Invest aims to explore how technology can bridge **personal financial planning and future elder care services**.

---

# ✨ Core Modules

| Module | Purpose | Status |
|---|---|---|
| 👤 User Management | Manage platform users and profiles | ✅ CRUD Implemented |
| 💼 Investor Management | Manage investor-specific information | ✅ CRUD Implemented |
| 📋 Investment Plans | Manage available investment plans | ✅ CRUD Implemented |
| 📈 Investments | Connect investors with investment plans | ✅ CRUD Implemented |
| 🏥 Facilities | Manage elder care facilities | ✅ CRUD Implemented |
| 🚪 Rooms | Manage rooms belonging to facilities | ✅ CRUD Implemented |
| 📅 Bookings | Reserve rooms/facilities | ✅ CRUD Implemented |
| 🩺 Facility Services | Manage services offered by facilities | ✅ CRUD Implemented |
| 🪪 KYC Verification | Investor identity verification | 🔜 Planned |
| 💰 Contributions | Investment contribution scheduling | 🔜 Planned |
| 💳 Payments | Process platform payments | 🔜 Planned |
| 🛡️ Insurance | Manage investor insurance policies | 🔜 Planned |
| 🔔 Notifications | User alerts and reminders | 🔜 Planned |
| 📑 Reports | Administrative and financial reports | 🔜 Planned |
| 🔐 Authentication | Login and authorization | 🚧 In Development |
| 🤖 AI Recommendations | Future financial/care recommendations | 🔮 Future |

---

# 🧰 Technology Stack

## Backend

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate ORM
- Maven
- Lombok
- Swagger / OpenAPI

## Database

- MySQL 8

## Planned Frontend

- React
- TypeScript
- Tailwind CSS

## Planned Authentication

- Spring Security
- JWT
- OAuth

## Planned DevOps / Deployment

- Docker
- AWS

## Development Tools

- Git
- GitHub
- IntelliJ IDEA
- VS Code
- WSL2 / Ubuntu
- Postman

---

# 🏗️ Backend Architecture

The current backend follows a layered Spring Boot architecture.

```text
                    Client / Postman
                           │
                           │ HTTP / REST
                           ▼
                 ┌───────────────────┐
                 │    Controller     │
                 └─────────┬─────────┘
                           │
                           ▼
                 ┌───────────────────┐
                 │      Service      │
                 │ Business Logic    │
                 └─────────┬─────────┘
                           │
                           ▼
                 ┌───────────────────┐
                 │    Repository     │
                 │ Spring Data JPA   │
                 └─────────┬─────────┘
                           │
                           ▼
                 ┌───────────────────┐
                 │      MySQL        │
                 │  eldernest_db     │
                 └───────────────────┘
```

For APIs involving relationships, request DTOs can sit between the client and controller:

```text
JSON Request
     │
     ▼
Request DTO
     │
     ▼
Controller
     │
     ▼
Service
     │
     ├── Find related entities
     │
     ▼
Repository
     │
     ▼
MySQL
```

---

# 🔗 Current Domain Relationships

The project is based on the ElderNest ERD.

Examples of implemented and planned relationships include:

```text
User
 │
 └── Investor

Investor
 │
 ├── Investments
 ├── Bookings
 ├── KYC Verifications
 └── Insurance Policies

InvestmentPlan
 │
 └── Investments

Investment
 │
 └── Contributions

Facility
 │
 ├── Rooms
 ├── Services
 └── Bookings

Booking
 │
 ├── Room
 └── Booking Services
```

For example:

```text
Facility 1 ─────────── * FacilityService
```

is represented in JPA using a `@ManyToOne` relationship from `FacilityService` to `Facility`.

---

# 📁 Repository Structure

```text
ElderCare-Invest/
│
├── backend/
│   ├── src/main/java/com/eldernest/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── repository/
│   │   ├── service/
│   │   └── ElderNestApplication.java
│   │
│   ├── src/main/resources/
│   │   └── application.properties
│   │
│   └── pom.xml
│
├── frontend/
├── database/
├── docs/
├── diagrams/
├── assets/
├── scripts/
├── tests/
├── README.md
└── LICENSE
```

> The repository structure will continue to evolve as frontend development, security, testing, and deployment are introduced.

---

# ⚙️ Backend Setup

## Prerequisites

Install:

- Java 21
- Maven
- MySQL 8
- Git

Verify:

```bash
java -version
mvn -version
mysql --version
git --version
```

---

## Clone the Repository

```bash
git clone https://github.com/sajan-2003/ElderCare-Invest.git
cd ElderCare-Invest/backend
```

---

# 🗄️ Database Setup

Create the database:

```sql
CREATE DATABASE eldernest_db;
```

The Spring Boot application uses environment variables for database credentials.

Linux / WSL example:

```bash
export DB_USERNAME='your_mysql_username'
export DB_PASSWORD='your_mysql_password'
```

The datasource configuration uses:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eldernest_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> 🔒 Database credentials should never be committed directly to GitHub.

---

# ▶️ Running the Backend

From:

```text
ElderCare-Invest/backend
```

run:

```bash
mvn spring-boot:run
```

The backend runs by default at:

```text
http://localhost:8080
```

---

# ❤️ Health Check

A health endpoint is available for checking whether the backend is running.

```http
GET /api/v1/health
```

Example:

```text
http://localhost:8080/api/v1/health
```

---

# 🔌 Current REST API

The backend uses versioned REST endpoints:

```text
/api/v1/...
```

Current modules include endpoints for:

```text
/api/v1/users
/api/v1/investors
/api/v1/investment-plans
/api/v1/investments
/api/v1/facilities
/api/v1/rooms
/api/v1/bookings
/api/v1/services
```

Each completed CRUD module generally supports:

| Method | Purpose |
|---|---|
| `POST` | Create resource |
| `GET` | Retrieve resources |
| `GET /{id}` | Retrieve resource by ID |
| `PUT /{id}` | Update resource |
| `DELETE /{id}` | Delete resource |

---

# 🩺 Example: Facility Service API

Create a service for an existing facility:

```http
POST /api/v1/services
```

Example request:

```json
{
  "facilityId": 2,
  "serviceName": "Physiotherapy",
  "description": "Professional physiotherapy sessions for elderly residents",
  "cost": 5000.00,
  "category": "Healthcare",
  "serviceStatus": "ACTIVE"
}
```

The backend resolves `facilityId` to the corresponding `Facility` entity before storing the relationship.

Conceptually:

```text
POST Request
     │
     │ facilityId = 2
     ▼
FacilityServiceRequest
     │
     ▼
FacilityServiceController
     │
     ▼
FacilityServiceService
     │
     ├── FacilityRepository.findById(2)
     │
     ▼
FacilityServiceRepository.save(...)
     │
     ▼
MySQL
```

---

# 🗺️ Development Roadmap

## Phase 1 — Planning & Design ✅

- [x] Project idea
- [x] Repository setup
- [x] Requirements
- [x] Stakeholder analysis
- [x] User stories
- [x] Use cases
- [x] ERD
- [x] UML diagrams
- [x] Architecture design
- [x] API planning

## Phase 2 — Backend 🚧

- [x] Spring Boot setup
- [x] Maven configuration
- [x] MySQL configuration
- [x] Spring Data JPA
- [x] User CRUD
- [x] Investor CRUD
- [x] Investment Plan CRUD
- [x] Investment CRUD
- [x] Facility CRUD
- [x] Room CRUD
- [x] Booking CRUD
- [x] Facility Service CRUD
- [x] Basic exception handling
- [x] Swagger/OpenAPI setup
- [ ] Remaining JPA entities
- [ ] Validation
- [ ] Authentication
- [ ] JWT authorization
- [ ] Role-based access control
- [ ] Automated tests

## Phase 3 — Frontend

- [ ] React + TypeScript setup
- [ ] Authentication UI
- [ ] User dashboard
- [ ] Investment dashboard
- [ ] Facility marketplace
- [ ] Booking interface
- [ ] Admin dashboard

## Phase 4 — Integration

- [ ] Connect frontend and backend
- [ ] API integration testing
- [ ] Security testing
- [ ] Dockerization
- [ ] Deployment

## Phase 5 — MVP

- [ ] MVP testing
- [ ] Deployment
- [ ] Final documentation
- [ ] Demo
- [ ] Portfolio presentation

---

# 🔮 Future Improvements

- 🤖 AI-powered investment and elder-care recommendations
- 📱 Mobile applications
- 🌐 Multi-language support
- 💱 Multi-currency support
- 🏢 Dedicated facility/provider portals
- 📡 Third-party healthcare and insurance integrations
- 📊 Predictive elder-care cost modelling
- ☁️ Cloud deployment and monitoring

---

# 🛡️ Security Considerations

The project is being designed with:

- Password hashing
- Spring Security
- JWT authentication
- Role-based authorization
- Environment-based secrets
- Input validation
- Secure REST APIs
- HTTPS for production
- Dependency vulnerability monitoring
- Least-privilege cloud access

Authentication and advanced security functionality are still under development.

---

# ⚠️ Disclaimer

ElderCare-Invest is an **educational and portfolio project**.

It is not currently a licensed financial, investment, healthcare, insurance, or elder-care service. Financial calculations, investment concepts, healthcare integrations, and insurance functionality implemented in this project are for educational and demonstration purposes.

---

# 🤝 Contributing

1. Fork the repository.

2. Create a feature branch:

```bash
git switch -c feature/your-feature-name
```

3. Stage your changes:

```bash
git add .
```

4. Commit:

```bash
git commit -m "Add feature description"
```

5. Push:

```bash
git push origin feature/your-feature-name
```

6. Open a Pull Request.

Please keep commits focused and use clear commit messages.

---

# 📄 License

This project is licensed under the **MIT License**. See the `LICENSE` file for details.

---

# 👤 Author

**Sajan Chamika**  
Founder & Lead Developer

GitHub: `@sajan-2003`

---

### 💬 "Plan today. Age with dignity tomorrow."

**ElderCare-Invest — building a bridge between long-term financial planning and future elder care.**
