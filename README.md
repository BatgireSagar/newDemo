# AI-Powered Client Onboarding Automation System

## Overview
A production-grade prototype for automating client onboarding in investment banking, featuring AI-powered KYC verification, data comparison, and workflow orchestration.

---

## Tech Stack
- **Frontend:** React + TailwindCSS
- **Backend:** Spring Boot (Java 21)
- **Database:** PostgreSQL
- **AI Integration:** AWS Bedrock (LAGLamda-cddGen)
- **Workflow:** Camunda 8 BPMN
- **DevOps:** Docker Compose

---

## Directory Structure
```
/workspace/
  /backend/         # Spring Boot app
  /frontend/        # React + TailwindCSS app
  /camunda/         # BPMN workflow files
  /db/              # PostgreSQL data (Docker volume)
  docker-compose.yml
  README.md
```

---

## Quick Start (Demo)

### 1. Prerequisites
- Docker & Docker Compose
- Java 21 (for manual backend build)
- Node.js 18+ (for manual frontend build)

### 2. Build & Run (All-in-One)
```bash
git clone <repo-url> onboarding-demo
cd onboarding-demo
docker-compose up --build
```
- Access **Frontend**: http://localhost:3000
- Access **Swagger UI**: http://localhost:8080/swagger-ui.html
- Access **Camunda**: http://localhost:8081
- PostgreSQL: localhost:5432 (user: `onboard`, pass: `onboardpw`)

### 3. Manual Build (Optional)
#### Backend
```bash
cd backend
./mvnw clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```
#### Frontend
```bash
cd frontend
npm install
npm run dev
```

---

## API Endpoints
- **POST** `/api/client/capture` – Submit CDD data
- **GET** `/api/data/compare/{caseId}` – Fetch external/internal data
- **POST** `/api/ai/analyze` – Run AI analysis
- **POST** `/api/contact-client/{caseId}` – Simulate client contact
- **GET** `/api/journey/decision/{caseId}` – Get onboarding route

See [Swagger UI](http://localhost:8080/swagger-ui.html) for full docs.

---

## Mock Data
- Preloaded demo cases in PostgreSQL for Companies House, Customer System, and CDD info.
- AI responses are mocked unless AWS Bedrock credentials are provided in `application.yaml`.

---

## Camunda Workflow
- BPMN file: `camunda/onboarding.bpmn`
- Steps: Capture → Fetch Data → AI Assessment → Review → Decision (Fast Track/Standard/EDD)

---

## Configuration
- Edit `backend/src/main/resources/application.yaml` for DB and Bedrock credentials.

---

## Postman Collection
- Import `docs/postman_collection.json` for API testing.

---

## Screenshots
- See `/docs/screenshots/` for UI and workflow previews.

---

## License
MIT