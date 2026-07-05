# API Design

> This document outlines the planned REST API endpoints for ElderCare-Invest. All endpoints listed here are **planned** and not yet implemented.

## Authentication

```
POST /auth/register
POST /auth/login
POST /auth/logout
```

## Users

```
GET  /users/me
PUT  /users/me
```

## Investments

```
POST /investments
GET  /investments
GET  /investments/:id
```

## Healthcare Plans

```
POST /healthcare-plans
GET  /healthcare-plans
```

## Facilities

```
GET  /facilities
GET  /facilities/:id
```

## Insurance

```
GET  /insurance-providers
POST /insurance/link
```

## Payments

```
POST /payments
GET  /payments
```

## Reports

```
GET /reports/:userId
```

## Notifications

```
GET /notifications
PUT /notifications/:id/read
```

## Documents

```
POST /documents
GET  /documents
```

## Admin

```
GET /admin/users
GET /admin/facilities
GET /admin/insurance-providers
```

---

> 📌 Request/response formats, authentication headers, and error handling conventions will be documented once the API is implemented.
