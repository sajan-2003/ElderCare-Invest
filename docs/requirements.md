# Software Requirements Specification

## ElderNest – Future Elder Care Investment Platform

---

## 1. Introduction

### 1.1 Purpose

This Software Requirements Specification (SRS) defines the functional and non-functional requirements for **ElderNest**, a digital platform that enables individuals to invest money over time to secure future accommodation and services at partnered elder care facilities. The document serves as a reference for the development, testing, and stakeholder-alignment phases of the project.

### 1.2 Scope

ElderNest will provide:

- Investor-facing tools for retirement and elder-care investment planning, tracking, and facility booking.
- Facility-facing tools for managing availability, services, and bookings.
- Administrator tools for platform oversight, verification, and compliance.
- Integrations with payment gateways, financial institutions, and (in future) healthcare providers.
- A foundation for future AI-powered financial guidance and recommendation features.

The initial release focuses on core investment management, facility discovery/booking, and administrative oversight. AI recommendation features and healthcare integrations are scoped as future enhancements.

### 1.3 Intended Audience

- Development and QA teams implementing and validating the system.
- Product managers and business analysts guiding feature prioritization.
- Elder care facility partners and operational staff.
- Compliance, legal, and regulatory reviewers.
- Investors and prospective users (as a reference for platform capabilities).

### 1.4 Definitions

| Term | Definition |
|---|---|
| Investor | A registered user who contributes funds toward a future elder care investment plan. |
| Investment Plan | A structured financial product defining contribution schedule, maturity terms, and projected value. |
| Facility | A partnered elder care provider offering accommodation and care services. |
| Maturity | The point at which an investment plan becomes eligible for withdrawal or facility booking. |
| Booking | A reservation of accommodation/services at a facility, funded by a matured or partial investment. |
| KYC | Know Your Customer — identity verification process required for financial compliance. |
| AML | Anti-Money Laundering — regulatory framework for detecting/preventing illicit fund flows. |

### 1.5 Assumptions

See Section 6.

### 1.6 Constraints

See Section 7.

---

## 2. Functional Requirements

### 2.1 Authentication

**FR-001** — The system shall allow users to register using email and password, with mandatory email verification before account activation.

**FR-002** — The system shall support social login (e.g., Google) as an alternative registration/login method.

**FR-003** — The system shall enforce multi-factor authentication (MFA) for all accounts holding or managing investment funds.

**FR-004** — The system shall allow users to reset forgotten passwords via a verified email or SMS channel.

**FR-005** — The system shall lock an account temporarily after five consecutive failed login attempts.

**FR-006** — The system shall support role-based login flows for Investor, Facility Manager, and Administrator user types.

### 2.2 User Profile Management

**FR-007** — The system shall allow investors to create and update a personal profile including name, date of birth, contact details, and identification documents.

**FR-008** — The system shall require identity verification (KYC) before an investor can activate an investment plan.

**FR-009** — The system shall allow investors to link one or more family members/guardians to their profile with configurable permission levels.

**FR-010** — The system shall allow users to update notification and communication preferences.

**FR-011** — The system shall maintain a change history/audit log for critical profile fields (e.g., bank details, beneficiary information).

### 2.3 Investment Management

**FR-012** — The system shall allow investors to browse and select from available investment plans.

**FR-013** — The system shall allow investors to initiate a new investment plan with a defined contribution amount, frequency, and target maturity date.

**FR-014** — The system shall calculate and display projected investment growth based on plan terms.

**FR-015** — The system shall allow investors to make one-time top-up contributions to an existing plan.

**FR-016** — The system shall allow investors to view real-time investment balance and historical performance.

**FR-017** — The system shall notify investors of missed or upcoming scheduled contributions.

**FR-018** — The system shall require administrator approval for any modification to an investment plan after maturity.

### 2.4 Investment Plans

**FR-019** — The system shall support multiple investment plan types (e.g., fixed-term, flexible-contribution, goal-based).

**FR-020** — The system shall allow administrators to create, update, and deactivate investment plan offerings.

**FR-021** — The system shall display plan-specific terms, projected returns, fees, and withdrawal conditions to investors before enrollment.

**FR-022** — The system shall allow investors to compare multiple investment plans side by side.

### 2.5 Payments

**FR-023** — The system shall integrate with a third-party payment gateway to process deposits and recurring contributions.

**FR-024** — The system shall support multiple payment methods (bank transfer, debit/credit card, digital wallet).

**FR-025** — The system shall generate a payment confirmation and receipt for every successful transaction.

**FR-026** — The system shall retry failed recurring payments according to a configurable retry policy before flagging the account.

**FR-027** — The system shall notify investors immediately upon payment failure.

### 2.6 Transactions

**FR-028** — The system shall maintain a complete, immutable transaction history for every investor account.

**FR-029** — The system shall allow investors to filter and export their transaction history.

**FR-030** — The system shall reconcile transaction records against payment gateway and financial institution reports on a scheduled basis.

**FR-031** — The system shall flag transactions exceeding a configurable threshold for administrator review (AML compliance).

### 2.7 Retirement Calculator

**FR-032** — The system shall provide a retirement/elder-care cost calculator allowing users to estimate future funding needs based on age, target retirement date, and desired facility tier.

**FR-033** — The system shall recommend an investment plan based on calculator inputs.

**FR-034** — The system shall allow users to save and revisit multiple calculator scenarios.

### 2.8 Elder Care Facilities

**FR-035** — The system shall allow verified facilities to create and manage a profile including services, amenities, pricing tiers, and media.

**FR-036** — The system shall require administrator verification and approval before a facility profile becomes publicly visible.

**FR-037** — The system shall allow facilities to update real-time room/bed availability.

**FR-038** — The system shall allow facilities to define eligibility criteria (e.g., care level, minimum investment maturity) for bookings.

### 2.9 Facility Search

**FR-039** — The system shall allow investors to search facilities by location, service type, price range, and availability.

**FR-040** — The system shall display facility ratings and reviews from previous residents or families where available.

**FR-041** — The system shall allow investors to save/favorite facilities for future reference.

### 2.10 Booking System

**FR-042** — The system shall allow investors to request a booking at a facility using matured or eligible investment funds.

**FR-043** — The system shall allow facility managers to approve, reject, or reschedule booking requests.

**FR-044** — The system shall notify both investor and facility upon any booking status change.

**FR-045** — The system shall support waitlist functionality when a requested facility/room is unavailable.

**FR-046** — The system shall generate a booking confirmation document upon approval.

### 2.11 Health Profile

**FR-047** — The system shall allow investors to optionally complete a basic health profile to support facility matching.

**FR-048** — The system shall restrict access to health profile data to the investor, authorized guardians, and (with consent) the booked facility.

**FR-049** — The system shall allow investors to update or delete health profile data at any time, subject to audit logging.

### 2.12 Notifications

**FR-050** — The system shall send notifications via email, SMS, and in-app channels for key events (payment due, booking status, plan maturity, security alerts).

**FR-051** — The system shall allow users to configure notification channel preferences per event type.

### 2.13 Reports

**FR-052** — The system shall generate periodic account statements for investors summarizing contributions, growth, and fees.

**FR-053** — The system shall allow facilities to generate occupancy and booking reports.

**FR-054** — The system shall allow administrators to generate platform-wide financial, compliance, and operational reports.

### 2.14 Administrator Dashboard

**FR-055** — The system shall provide administrators with a dashboard summarizing active investors, total funds under management, facility partners, and pending approvals.

**FR-056** — The system shall allow administrators to suspend or terminate user or facility accounts for policy violations.

**FR-057** — The system shall log all administrative actions with timestamp and administrator identity.

### 2.15 Analytics

**FR-058** — The system shall provide administrators with analytics on investment plan performance, user growth, and facility utilization trends.

**FR-059** — The system shall allow filtering of analytics data by date range, region, and plan type.

### 2.16 AI Recommendation Module (Future)

**FR-060** — The system shall (in a future release) provide AI-generated investment plan recommendations based on an investor's financial profile, goals, and risk tolerance.

### 2.17 Security Features

**FR-061** — The system shall encrypt all sensitive personal and financial data at rest and in transit.

**FR-062** — The system shall require biometric or MFA re-authentication before high-risk actions (e.g., withdrawal requests, beneficiary changes).

---

## 3. Non-Functional Requirements

### Performance

**NFR-001** — The system shall authenticate users within 3 seconds under normal operating conditions.

**NFR-002** — The system shall load an investor's dashboard within 2 seconds for accounts with up to 10 years of transaction history.

**NFR-003** — The system shall process a standard payment transaction within 5 seconds under normal load.

### Security

**NFR-004** — The system shall encrypt all data at rest using AES-256 or equivalent.

**NFR-005** — The system shall enforce TLS 1.2 or higher for all data in transit.

**NFR-006** — The system shall store passwords using an adaptive hashing algorithm (e.g., Argon2id or bcrypt).

**NFR-007** — The system shall enforce role-based access control across all administrative and facility-management functions.

### Reliability

**NFR-008** — The system shall maintain a transaction success rate of at least 99.5% under normal operating conditions.

**NFR-009** — The system shall automatically retry failed non-payment operations (e.g., notification delivery) up to three times before logging a failure.

### Scalability

**NFR-010** — The system shall support horizontal scaling to accommodate growth to at least 1 million registered investors without architectural redesign.

**NFR-011** — The system shall support independent scaling of the payment-processing and facility-search subsystems.

### Availability

**NFR-012** — The system shall maintain a minimum uptime of 99.9% measured monthly.

**NFR-013** — The system shall provide automated failover to a secondary region within 5 minutes of a primary region outage.

### Maintainability

**NFR-014** — The system shall be built using modular, layered architecture to allow independent updates to individual modules.

**NFR-015** — The system shall maintain automated test coverage of at least 80% for core financial transaction logic.

### Usability

**NFR-016** — The system shall enable a first-time user to complete registration and initiate an investment plan within 10 minutes without external assistance.

**NFR-017** — The system shall provide clear, jargon-free explanations of investment terms and fees at the point of decision.

### Accessibility

**NFR-018** — The system shall conform to WCAG 2.1 AA accessibility standards across all investor-facing interfaces.

**NFR-019** — The system shall support text scaling up to 200% without loss of functionality.

### Compatibility

**NFR-020** — The system shall support the latest two major versions of iOS and Android for mobile access.

**NFR-021** — The system shall support the latest versions of major web browsers (Chrome, Safari, Firefox, Edge) for web access.

### Backup and Recovery

**NFR-022** — The system shall perform automated daily backups of all transactional and user data.

**NFR-023** — The system shall achieve a Recovery Point Objective (RPO) of 1 hour and a Recovery Time Objective (RTO) of 4 hours.

### Logging

**NFR-024** — The system shall log all financial transactions, administrative actions, and authentication events in a tamper-evident audit log.

**NFR-025** — The system shall retain audit logs for a minimum of 7 years to satisfy financial compliance requirements.

### Monitoring

**NFR-026** — The system shall provide real-time monitoring of transaction failure rates, API latency, and system error rates.

**NFR-027** — The system shall trigger automated alerts when key metrics exceed configured thresholds.

### Privacy

**NFR-028** — The system shall allow investors to request export or deletion of their personal data in compliance with applicable data protection law.

**NFR-029** — The system shall restrict health profile data access strictly to authorized parties with explicit consent.

### Compliance

**NFR-030** — The system shall support configurable compliance workflows (KYC/AML) to meet regional financial regulatory requirements.

---

## 4. Business Rules

**BR-001** — Users must be at least 18 years old to create an investment plan.

**BR-002** — Investment plans cannot be modified after maturity without administrator approval.

**BR-003** — Only verified elder care facilities may accept bookings through the platform.

**BR-004** — All investors must complete KYC verification before their first contribution is processed.

**BR-005** — Withdrawals prior to plan maturity are subject to an early-withdrawal fee, as defined per plan type.

**BR-006** — A facility must maintain a minimum verified rating/compliance status to remain listed on the platform.

**BR-007** — Guardians linked to an investor's account may only access information explicitly permitted by the investor.

**BR-008** — Bookings may only be confirmed against funds that have reached eligible maturity status, unless an early-release exception is approved by an administrator.

**BR-009** — Transactions exceeding a defined threshold require secondary verification before processing (AML compliance).

**BR-010** — Facility Managers may only manage the facility profile(s) to which they are assigned by an Administrator.

**BR-011** — Investment plan terms (fees, projected returns) may not be altered retroactively for existing enrolled investors.

**BR-012** — An account flagged for suspicious activity shall be temporarily restricted from initiating new transactions pending administrator review.

**BR-013** — Health profile data may only be shared with a facility after explicit investor consent tied to a specific booking.

**BR-014** — A facility booking may be cancelled by the investor within a defined grace period without penalty.

**BR-015** — Administrators must approve all new facility partner onboarding before the facility becomes publicly visible.

**BR-016** — Recurring payment failures beyond a defined retry limit shall result in a formal notice and grace period before plan suspension.

**BR-017** — All fund transfers must be processed exclusively through approved, integrated payment gateway and financial institution partners.

**BR-018** — A user may hold multiple investment plans concurrently, subject to platform-defined maximum limits.

---

## 5. External System Requirements

| External System | Requirement |
|---|---|
| Payment Gateway | Must support secure processing of one-time and recurring transactions with webhook-based status callbacks. |
| Email Service | Must support transactional email delivery (verification, receipts, alerts) with delivery tracking. |
| SMS Service | Must support OTP delivery and critical alert notifications across supported regions. |
| Cloud Storage | Must support encrypted storage of identity documents, facility media, and health profile attachments. |
| Authentication Provider | Must support OAuth2/OIDC-based social login integration. |
| Future Healthcare API | Must support standards-based (e.g., FHIR) exchange of consented health profile data. |
| Banking API | Must support secure account verification and fund transfer confirmation with the Financial Institution partner. |

---

## 6. Assumptions

- Investors have access to a smartphone or web browser and a valid government-issued ID for KYC verification.
- Partnered elder care facilities are willing to integrate their availability and booking data with the platform.
- Payment gateway and financial institution partners provide reliable, well-documented APIs.
- Regulatory frameworks for investment-based elder care platforms exist or can be reasonably complied with in initial target markets.
- Users are able to read and understand platform content in the primary supported language(s) at launch.
- Healthcare provider integration will not be required for the initial release.

---

## 7. Constraints

**Technical Constraints:**
- The system must integrate with third-party payment and financial institution APIs, whose rate limits and data formats are outside ElderNest's control.
- Initial release constrained to mobile (iOS/Android) and web platforms only; no native desktop application planned at launch.

**Legal Constraints:**
- The platform must comply with financial services regulations (e.g., investment product licensing) in each operating jurisdiction.
- Health data handling (future) must comply with applicable health privacy regulations (e.g., HIPAA or regional equivalents).
- Data protection compliance (e.g., GDPR, CCPA, or regional equivalents) is mandatory for all personal data processing.

**Business Constraints:**
- Initial launch is limited to a defined set of pilot regions and partnered facilities.
- Budget and timeline constraints limit the AI Recommendation Module and Healthcare Provider integration to post-launch phases.

---

## 8. Future Enhancements

- **AI-Powered Financial Guidance:** Personalized investment recommendations and risk assessment based on machine learning models.
- **Healthcare Provider Integration:** Direct, consented exchange of health records to improve facility matching and care continuity.
- **Insurance Product Bundling:** Optional long-term care insurance products offered alongside investment plans.
- **Secondary Market for Investment Plans:** Allowing transfer or resale of investment plans between users under regulatory-approved conditions.
- **International Expansion Support:** Multi-currency investment plans and cross-border facility booking.
- **Family Legacy & Estate Planning Tools:** Integration with legal/estate planning services for beneficiary and inheritance management.
- **Voice/Chat-Based Virtual Advisor:** Conversational interface for retirement planning guidance and customer support.
