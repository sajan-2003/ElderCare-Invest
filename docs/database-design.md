# Database Design

> This document lists the planned database tables for ElderCare-Invest. Detailed schemas (columns, types, relationships) will be added as the database design is finalized.

## Planned Tables

```
Users
Investments
Transactions
HealthcarePlans
Facilities
InsuranceProviders
Payments
Notifications
Documents
Admins
```

## Notes

- **Users** — stores core user account and profile information.
- **Investments** — stores each user's investment plan(s) and goals.
- **Transactions** — records individual contributions/withdrawals tied to an investment plan.
- **HealthcarePlans** — stores healthcare plans linked to a user.
- **Facilities** — stores partnered elder care facility listings.
- **InsuranceProviders** — stores partnered insurance provider and policy information.
- **Payments** — records payment activity related to investments or services.
- **Notifications** — stores reminders and alerts sent to users.
- **Documents** — stores metadata/references for securely stored user documents.
- **Admins** — stores administrator accounts for platform management.

> ⚠️ Table relationships, primary/foreign keys, and column-level details are planned and will be documented once the schema design phase begins.
