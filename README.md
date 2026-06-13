# Dreamcatcher API

A RESTful API serving data about the K-pop group **Dreamcatcher** -- members, discography, albums, and songs.

---

## Tech Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | via Spring Boot BOM |
| PostgreSQL | 15 |
| Flyway | via Spring Boot BOM |
| SpringDoc OpenAPI | 3.0.2 |
| Gradle | 9.x |
| Docker | 24+ |
| Lombok | 1.18.46 |

---

## Prerequisites

- **Java 21** or higher
- **Docker** and **Docker Compose**

---

## Setup

### 1. Clone

```bash
git clone git@github.com:NingJjwo/dreamcatcher-api.git
cd dreamcatcher-api
```

### 2. Environment variables

Create a `.env` file in the project root with your own credentials (these are just example values):

```env
POSTGRES_USER=dreamcatcher
POSTGRES_PASSWORD=your_secure_password
POSTGRES_DB=dreamcatcher_db
POSTGRES_PORT=5432

DB_URL=jdbc:postgresql://localhost:5432/dreamcatcher_db
DB_USERNAME=dreamcatcher
DB_PASSWORD=your_secure_password
```

### 3. Start PostgreSQL

```bash
docker compose up -d
```

### 4. Run

```bash
./gradlew bootRun
```

The API runs at `http://localhost:8080`

Swagger UI at `http://localhost:8080/swagger-ui/index.html`

---

## License

This project is for fan purposes only. All Dreamcatcher-related content belongs to their respective owners.