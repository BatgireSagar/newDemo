# Onboarding Backend

## Setup

### Prerequisites
- Java 21
- Maven
- PostgreSQL (or use Docker Compose)

### Build

```bash
cd backend
./mvnw clean package
```

### Run

```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

### API Docs
- Swagger UI: http://localhost:8080/swagger-ui.html

### Database
- Uses PostgreSQL (see `application.yaml` for config)
- Mock data loaded from `src/main/resources/data.sql`

### Features
- REST APIs for client onboarding
- OpenAPI annotations
- AI integration (mocked, Bedrock ready)
- Camunda workflow integration