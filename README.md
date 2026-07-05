<div align="center">

# 🧓💰 ElderCare-Invest

### Invest Early. Age Gracefully. Retire Prepared.

**A digital platform that helps individuals invest and plan financially for their future elder care — starting from a young age.**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](#-license)
[![Status](https://img.shields.io/badge/status-in%20development-orange)](#-roadmap)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](#-contribution-guidelines)
[![React](https://img.shields.io/badge/Frontend-React%20%2B%20TypeScript-61DAFB?logo=react&logoColor=white)](#-technology-stack)
[![Node.js](https://img.shields.io/badge/Backend-Node.js%20%2B%20Express-339933?logo=node.js&logoColor=white)](#-technology-stack)
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-4169E1?logo=postgresql&logoColor=white)](#-technology-stack)
[![Docker](https://img.shields.io/badge/Container-Docker-2496ED?logo=docker&logoColor=white)](#-technology-stack)
[![AWS](https://img.shields.io/badge/Cloud-AWS-FF9900?logo=amazonaws&logoColor=white)](#-technology-stack)

</div>

---

## 🚧 Current Status

This project is currently in the **planning and documentation phase**.

**Completed:**
- ✅ Repository setup
- ✅ Initial project structure
- ✅ README documentation

**Upcoming:**
- 🔲 Requirements analysis
- 🔲 Database design
- 🔲 UI/UX wireframes
- 🔲 Backend development
- 🔲 Frontend development

---

## ⚠️ Disclaimer

ElderCare-Invest is an **educational and portfolio project**. It is **not** a licensed financial, insurance, healthcare, or investment service.

---

## 📖 Short Description

**ElderCare-Invest** is a fintech-meets-healthcare platform that lets people start saving and investing for their future elder care decades before they need it. Rather than treating elder care as a retirement-age emergency, users build a dedicated financial plan over time — one that connects directly to real elder care facilities, healthcare providers, and insurance partners.

---

## ❗ Problem Statement

- 🏥 Elder care and quality assisted living are **expensive and often unaffordable** when the need suddenly arises.
- 📉 Most people **don't plan financially for elder care** until it's too late — usually during a health crisis.
- 🧩 Financial planning tools and elder care services exist **in silos** — there's no single platform connecting long-term investment to actual care outcomes.
- 🌐 Families are often left to **navigate elder care options alone**, without transparent pricing or verified providers.
- 📊 There is a **lack of visibility** into how today's savings translate into tomorrow's care options.

---

## 💡 Solution Overview

ElderCare-Invest addresses this gap by combining **long-term investment tools** with a **marketplace of vetted elder care, healthcare, and insurance providers**, allowing users to:

1. Start investing early through structured, goal-based plans.
2. Track their portfolio growth toward a specific elder care goal.
3. Explore and pre-plan with real elder care facilities and insurance providers.
4. Manage healthcare plans and documents in one secure place.
5. Receive timely reminders and reports to stay on track.

---

## 🌍 Vision

> To make **quality elder care a plannable, affordable outcome** — not a financial emergency — by empowering individuals to start investing in their future care from the earliest years of their careers.

Long-term, ElderCare-Invest aims to become the **bridge between personal finance and aging-in-dignity**, trusted by individuals, families, and institutions alike.

---

## ✨ Key Features

| Feature | Description | Status |
|---|---|---|
| 🔐 User Authentication & Profiles | Secure sign-up/login with profile management | Planned |
| 📈 Long-Term Investment Plans | Goal-based investment plans tailored to elder care | Planned |
| 📊 Investment Portfolio Dashboard | Real-time view of contributions, growth, and projections | Planned |
| 🧮 Retirement Savings Calculator | Estimate future elder care costs and savings needed | Planned |
| 🏥 Healthcare Plan Management | Manage healthcare plans linked to the user profile | Planned |
| 🏘️ Elder Care Facility Marketplace | Browse and compare partnered elder care facilities | Planned |
| 🛡️ Insurance Integration | Connect with insurance providers and policies | Planned |
| 💳 Online Payments | Secure recurring and one-time investment contributions | Planned |
| 📑 Financial Reports & Analytics | Downloadable reports and visual analytics | Planned |
| 🔔 Notifications & Reminders | Alerts for contributions, milestones, and renewals | Planned |
| 🗄️ Secure Document Storage | Encrypted storage for financial and medical documents | Planned |
| 🛠️ Admin Dashboard | Manage users, providers, and platform operations | Planned |
| 🤖 AI-Powered Recommendations | Personalized financial and care guidance using AI | **Future** |

---

## 🧰 Technology Stack

<table>
<tr>
<td valign="top" width="50%">

**Frontend**
- ⚛️ React
- 🟦 TypeScript
- 🎨 Tailwind CSS

**Backend**
- 🟢 Node.js
- 🚂 Express.js

**Database**
- 🐘 PostgreSQL

</td>
<td valign="top" width="50%">

**Authentication**
- 🔑 JWT
- 🌐 OAuth

**Cloud & DevOps**
- 🐳 Docker
- ☁️ AWS

**Version Control & Docs**
- 🔧 Git & GitHub
- 📝 Markdown

</td>
</tr>
</table>

---

## 🏗️ System Architecture Overview

> High-level architecture — subject to change as the system evolves.

```
                         ┌──────────────────────┐
                         │       Clients        │
                         │ (Web App - React/TS) │
                         └──────────────────────┘
                                     |
                                     │ HTTPS / REST API
                                     ▼
                          ┌────────────────────┐
                          │   API Gateway /    │
                          │ Express.js Backend │
                          └────────────────────┘
                                     │
                ┌────────────────────┴─────────────────┐
                │                    │                 │
        ┌───────────────┐   ┌────────────┐   ┌──────────────────┐
        │ Auth Service  │   │ Investment │   │  Marketplace &   │
        │ (JWT / OAuth) │   │  Service   │   │ Provider Service │
        └───────────────┘   └────────────┘   └──────────────────┘
                │                    │                  │
                └────────────────────┴──────────────────┘
                                     ▼
                            ┌───────────────┐
                            │ PostgreSQL DB │
                            └───────────────┘
                                     │
                                     ▼
                         ┌──────────────────────┐
                         │ Cloud Infrastructure │
                         │    (Docker + AWS)    │
                         └──────────────────────┘
```

<details>
<summary>📌 Architectural Notes</summary>

- The backend follows a **modular service-oriented structure** within a monolithic Express.js application (future potential to evolve into microservices).
- PostgreSQL serves as the **single source of truth** for user, investment, and provider data.
- Authentication is handled via **JWT for session management** and **OAuth for third-party logins**.
- The application is containerized with **Docker** for consistent local development and deployment, and hosted on **AWS**.

</details>

---

## 📁 Repository Structure

```
ElderCare-Invest/
├── frontend/                 # React + TypeScript client application
├── backend/                  # Node.js + Express server application
├── database/                 # Database schemas, migrations, and seed data
├── docs/                     # Project documentation
├── assets/                   # Images, diagrams, and static assets
├── scripts/                  # Utility and automation scripts
├── src/                      # Shared/core source code
├── tests/                    # Test suites
├── docker-compose.yml
├── .env.example
├── LICENSE
└── README.md
```

> ⚠️ Structure reflects the planned project layout and may evolve as development progresses.

---

## ⚙️ Installation Guide

> 📌 Installation instructions will be updated after frontend and backend setup is implemented. The steps below reflect the **planned** setup process.

### Prerequisites

- Node.js `>= 18.x`
- npm or yarn
- PostgreSQL `>= 14.x`
- Docker (optional, for containerized setup)
- Git

### Clone the Repository

```bash
git clone https://github.com/sajan-2003/ElderCare-Invest.git
cd ElderCare-Invest
```

### Install Dependencies

<details>
<summary><strong>Frontend</strong></summary>

```bash
cd frontend
npm install
```

</details>

<details>
<summary><strong>Backend</strong></summary>

```bash
cd backend
npm install
```

</details>

---

## ▶️ Running the Project

### Option 1: Manual Setup

```bash
# Start PostgreSQL locally, then run migrations (planned)

# Start backend
cd backend
npm run dev

# Start frontend (in a separate terminal)
cd frontend
npm run dev
```

### Option 2: Using Docker

```bash
docker-compose up --build
```

The frontend will be available at `http://localhost:3000` and the backend API at `http://localhost:5000` *(default ports — configurable via environment variables)*.

---

## 🔑 Environment Variables

Create a `.env` file in the `backend/` directory based on `.env.example`:

```env
# Server
PORT=5000
NODE_ENV=development

# Database
DATABASE_URL=postgresql://username:password@localhost:5432/eldercare_invest

# Authentication
JWT_SECRET=your_jwt_secret_here
OAUTH_CLIENT_ID=your_oauth_client_id
OAUTH_CLIENT_SECRET=your_oauth_client_secret

# Payments (Planned integration)
PAYMENT_GATEWAY_KEY=your_payment_gateway_key

# Cloud / AWS (Planned integration)
AWS_ACCESS_KEY_ID=your_aws_access_key
AWS_SECRET_ACCESS_KEY=your_aws_secret_key
AWS_REGION=your_aws_region
```

> 🔒 Never commit your actual `.env` file. Use `.env.example` as a template.

---

## 🔌 API Overview

> The API follows RESTful principles. Endpoints below represent the **planned initial API surface**.

| Method | Endpoint | Description | Status |
|---|---|---|---|
| `POST` | `/api/auth/register` | Register a new user | Planned |
| `POST` | `/api/auth/login` | Authenticate a user | Planned |
| `GET` | `/api/users/me` | Get current user profile | Planned |
| `POST` | `/api/investments` | Create a new investment plan | Planned |
| `GET` | `/api/investments/:userId` | Get user's investment portfolio | Planned |
| `GET` | `/api/facilities` | Browse elder care facility marketplace | Planned |
| `POST` | `/api/insurance/link` | Link an insurance policy | Planned |
| `POST` | `/api/payments` | Process an investment payment | Planned |
| `GET` | `/api/reports/:userId` | Fetch financial reports & analytics | Planned |

<details>
<summary>📄 Sample Response Format</summary>

```json
{
  "success": true,
  "data": {
    "id": "uuid",
    "message": "Resource retrieved successfully"
  }
}
```

</details>

---

## 🖼️ Screenshots

> 📌 Screenshots and UI previews will be added here as development progresses.

| Dashboard | Investment Portfolio | Marketplace |
|---|---|---|
| *Coming Soon* | *Coming Soon* | *Coming Soon* |

---

## 🗺️ Roadmap

- [x] Project planning & architecture design
- [ ] Core authentication & user profile module
- [ ] Investment plan creation & portfolio dashboard
- [ ] Retirement savings calculator
- [ ] Elder care facility marketplace (MVP)
- [ ] Payment gateway integration
- [ ] Insurance provider integration
- [ ] Admin dashboard
- [ ] Financial reports & analytics module
- [ ] Notifications & reminders system
- [ ] Secure document storage
- [ ] **Future:** AI-powered financial recommendations
- [ ] **Future:** Mobile application (iOS/Android)

---

## 🚀 Future Improvements

- 🤖 AI-driven personalized investment and care recommendations
- 📱 Native mobile applications
- 🌐 Multi-language and multi-currency support
- 🏢 Dedicated portals for elder care organizations and insurance providers
- 📡 Open API for third-party healthcare/insurance integrations
- 🔍 Advanced analytics and predictive cost modeling

---

## 🛡️ Security Considerations

- 🔐 Passwords are never stored in plain text — hashed using industry-standard algorithms (planned).
- 🔑 Authentication is handled via **JWT** with **OAuth** support for third-party sign-in.
- 🗄️ Sensitive documents and financial data will be encrypted at rest and in transit.
- 🧾 Environment variables and secrets are excluded from version control via `.gitignore`.
- 🧪 Planned: rate limiting, input validation, and dependency vulnerability scanning.
- ☁️ Cloud infrastructure (AWS) will follow least-privilege IAM access principles.

> ⚠️ Security features marked above reflect intended design standards and will be implemented progressively.

---

## 🤝 Contribution Guidelines

Contributions are welcome! To contribute:

1. **Fork** the repository
2. Create a new branch
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes
   ```bash
   git commit -m "Add: your feature description"
   ```
4. Push to your branch
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a **Pull Request** with a clear description of your changes

### Guidelines

- Follow existing code style and naming conventions.
- Write clear, descriptive commit messages.
- Ensure your code is well-documented.
- Test your changes before submitting a PR.

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](./LICENSE) file for details.

---

## 👤 Authors

**Sajan Chamika**
Founder & Lead Developer

- GitHub: [@sajan-2003](https://github.com/sajan-2003)

---

<div align="center">

### 💬 "Plan today. Age with dignity tomorrow."

**ElderCare-Invest** — Built with ❤️ to make elder care planning accessible for everyone.

⭐ If you find this project interesting, consider giving it a star on GitHub!

</div>
