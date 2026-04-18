# Quiniela Mundial FIFA 2026

## Descripción del proyecto
Aplicación web de quiniela para el Mundial FIFA 2026. Los usuarios pueden registrarse, ingresar sus pronósticos por partido y competir en una clasificación global con reglas de puntaje simples.

## Tecnologías
- Kotlin (JVM 21)
- Spring Boot 3.x
- Gradle Kotlin DSL
- Spring Security (form login + OAuth2 Client Google)
- Thymeleaf + thymeleaf-layout-dialect
- HTMX + Alpine.js
- Tailwind CSS
- PostgreSQL
- Flyway
- JUnit 5 + MockK + SpringBootTest
- GitHub Actions

## Requisitos previos
- JDK 21
- Docker (para PostgreSQL usando Spring Boot Docker Compose support)

## Guía de inicio rápido
1. Clona el repositorio:
   ```bash
   git clone <repo-url>
   cd Quiniela-Mundial
   ```
2. PostgreSQL se inicia automáticamente por Spring Boot al detectar `compose.yaml`.
   - No necesitas ejecutar `docker compose up` manualmente.
3. Ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```
4. Credenciales admin por defecto:
   - Email: `admin@quinielamundial.com`
   - Password: `Admin123!` (hash BCrypt en `V2__seed_admin.sql`)
5. Configura Google OAuth (opcional) con variables de entorno:
   - `GOOGLE_CLIENT_ID`
   - `GOOGLE_CLIENT_SECRET`

## Estructura del proyecto
Arquitectura híbrida:
- Presentación separada (`web/` para SSR Thymeleaf + HTMX, `api/v1/` para JSON REST)
- Dominio organizado por feature (`match/`, `prediction/`, `scoring/`, `ranking/`, `team/`, `user/`, `auth/`)
- Configuración transversal en `config/` y manejo global de errores en `shared/`

## Ejecutar tests
```bash
./gradlew test
```

## Reglas del juego
- 3 puntos por resultado exacto.
- 1 punto si no es exacto pero aciertas la tendencia (gana local, visitante o empate).
- 0 puntos si no aciertas.
- Solo se permite un pronóstico por usuario y partido.
- El pronóstico se cierra 30 minutos antes del inicio del partido.
