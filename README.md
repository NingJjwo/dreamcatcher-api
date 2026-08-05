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

## Database & Migrations

> Read this before touching the database. The data setup was fought over for hours once; these rules prevent that.

### How the schema is managed

- All schema and data live in PostgreSQL. Local: the `dreamcatcher_postgres` container (DB `dreamcatcher_db`, credentials in `.env`). Production: Render managed Postgres `dreamcatcher_db_e5il`.
- **Spring Boot 4 removed Flyway's auto-configuration.** This app runs Flyway manually: `src/main/java/.../config/FlywayConfig.java` creates a `Flyway` bean and calls `migrate()` at startup.
- `spring.jpa.hibernate.ddl-auto=none` — Hibernate never creates or alters tables. **Every schema/data change MUST be a Flyway migration** in `src/main/resources/db/migration/`.
- Migrations run automatically on every startup (local and Render). A fresh database gets the full chain; an existing database with data is baselined at version `0` (`baselineOnMigrate=true`) and gets only the pending migrations. No manual `psql` seeding is ever needed.

### The rules (do not skip)

1. **Never edit an already-applied migration (`V1`–`V4`).** Flyway validates checksums — editing one breaks startup on any DB that applied it. Fix forward: add `V5__...`, `V6__...`, etc.
2. Prefix new columns with `ALTER TABLE ... ADD COLUMN IF NOT EXISTS`, renames with `ALTER TABLE ... RENAME COLUMN`, so the same migration is safe on Hibernate-created and V1-created schemas.
3. Seed/mutation INSERTs use explicit column lists, `OVERRIDING SYSTEM VALUE`, `ON CONFLICT DO NOTHING`, and finish with `setval()` on the sequence so auto-increment keeps working.
4. Renaming an identity column does **not** rename its sequence — rename it explicitly too (`ALTER SEQUENCE ... RENAME TO ...`).
5. After adding a migration, verify locally against **both** shapes: a fresh scratch DB and the existing dev DB (see "Verifying").

### Current schema (as of V4)

- **Primary keys are uniformly named `id`** (tables: `groups`, `idols`, `positions`, `albums`, `songs`).
- Foreign-key/reference columns keep their semantic names: `group_id`, `album_id`, and the join table `idol_positions(idol_id, position_id)`.
- Tables live in the `api` schema; the Flyway history table is `public.flyway_schema_history`.
- `api.idols.nationality`: `South Korean` for all members except Handong (`Chinese`).

### Current data

| Table | Rows |
|-------|------|
| `groups` | 1 |
| `idols` | 7 |
| `positions` | 14 |
| `idol_positions` | 16 |
| `albums` | 34 |
| `songs` | 161 |

### Connecting

Local:

```bash
docker compose up -d
docker exec -it dreamcatcher_postgres psql -U dreamcatcher -d dreamcatcher_db
```

Production (Render):

```bash
psql postgresql://<DB_USERNAME>:<DB_PASSWORD>@dpg-d9pa7nnavr4c73b6ng6g-a.virginia-postgres.render.com/dreamcatcher_db_e5il
```

The app reads `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` (set via `.env` locally — `build.gradle` loads it into `bootRun`/tests — and via Render env vars in production).

### Verifying a migration

```bash
# fresh shape
createdb dreamcatcher_db_fresh
./gradlew bootRun --args='--spring.datasource.url=jdbc:postgresql://localhost:5432/dreamcatcher_db_fresh --spring.datasource.username=dreamcatcher --spring.datasource.password=password123 --server.port=8099'
curl -s localhost:8099/api/songs | python3 -c 'import json,sys; print(len(json.load(sys.stdin)))'   # expect 161

# existing shape: just ./gradlew test (context loads against the dev DB and applies migrations)
```

### Gotchas

- The compiled frontend bundle (`src/main/resources/static/assets/index-*.js`) is an API-docs page that does **not** read the JSON fields — renaming DTO fields (e.g. `id` for ids) is safe; don't hand-edit the minified bundle.
- The DTO/JSON layer intentionally uses `id` while FK columns stay `group_id`/`album_id` — match that, don't "simplify" it back.

---

## License

This project is for fan purposes only. All Dreamcatcher-related content belongs to their respective owners.