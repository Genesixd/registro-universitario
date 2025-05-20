# 🎓 Sistema de Registro Universitario - Spring Boot

Este proyecto es una API RESTful desarrollada en **Spring Boot** que permite la gestión de estudiantes, materias e inscripciones en un entorno universitario. Está diseñado con seguridad basada en **JWT**, documentación Swagger/OpenAPI y soporte de cache con **Redis**.

---

## 🚀 Características principales

- Autenticación y autorización con JWT.
- Roles: `ADMIN`, `DOCENTE`, `ESTUDIANTE`.
- CRUD completo de:
  - Estudiantes
  - Materias
  - Inscripciones
- Validaciones y manejo de errores personalizados.
- Documentación con Swagger (OpenAPI).
- Cache con Redis en endpoints de estudiantes y materias.
- Soporte para pruebas asincrónicas (envío de confirmación).

---

## 📦 Tecnologías usadas

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Redis (opcional)
- Swagger (springdoc-openapi)
- Maven

---

## ⚙️ Configuración previa

Antes de ejecutar el proyecto, asegurate de configurar correctamente los siguientes aspectos:

### 🔧 `application.properties`

Ubicado en `src/main/resources/application.properties`, debes modificar lo siguiente según tu entorno local:

```properties
# ⚠️ Configura estos parámetros

# Puerto y credenciales de PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5433/registrodb
spring.datasource.username=postgres
spring.datasource.password=123456

# Puerto del servidor
server.port=8082

# Configuración opcional de Redis
# spring.cache.type=redis
# spring.data.redis.host=localhost
# spring.data.redis.port=6379
```

---

### ⚠️ IMPORTANTE

Asegúrate de que el puerto de tu PostgreSQL (`5433`) y tu contraseña (`123456`) coincidan con tu instalación local.  
Si usás otro puerto o contraseña, modificalos en el archivo `application.properties` o `application.yml`.

---

## 🧪 Endpoints disponibles

Accedé a la documentación Swagger en:  
📍 [http://localhost:8082/swagger-ui/index.html](http://localhost:8082/swagger-ui/index.html)

---

### 🔓 Rutas públicas (sin autenticación)

- `POST /auth/register` – Registrar usuario  
- `POST /auth/login` – Iniciar sesión y obtener JWT

---

### 🔐 Rutas protegidas (requieren token JWT)

#### Estudiantes
- `GET /api/estudiantes` – Listar todos los estudiantes  
- `GET /api/estudiantes/{id}` – Obtener estudiante por ID  
- `POST /api/estudiantes` – Registrar un nuevo estudiante  
- `PUT /api/estudiantes/{id}` – Actualizar estudiante  
- `DELETE /api/estudiantes/{id}` – Eliminar estudiante  

#### Materias
- `GET /api/materias` – Listar todas las materias  
- `GET /api/materias/{id}` – Obtener materia por ID  
- `POST /api/materias` – Registrar nueva materia  
- `PUT /api/materias/{id}` – Actualizar materia  
- `DELETE /api/materias/{id}` – Eliminar materia  

#### Inscripciones
- `GET /api/inscripciones` – Listar todas las inscripciones  
- `GET /api/inscripciones/{id}` – Obtener inscripción por ID  
- `POST /api/inscripciones` – Registrar nueva inscripción  
- `DELETE /api/inscripciones/{id}` – Eliminar inscripción

---

> Usá el botón **Authorize 🔒** en Swagger para ingresar tu token JWT y acceder a los endpoints protegidos.

---

## ▶️ Cómo ejecutar el proyecto

1. Asegúrate de que tu base de datos **PostgreSQL** esté activa.  
2. (Opcional) Tener **Redis** corriendo si vas a usar cache.

---

### 🛠️ Preparar la base de datos

Antes de ejecutar el proyecto, crea una base de datos llamada `registro` en PostgreSQL.  
Podés hacerlo desde la terminal de `psql` o desde PgAdmin:

```sql
CREATE DATABASE registro;
```

---

### ▶️ Ejecutar el proyecto

Cloná el proyecto y ejecutá los siguientes comandos en la raíz:

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🧠 Observaciones

- Si **Redis no está instalado**, comentá o eliminá las líneas relacionadas en `application.properties` para evitar errores.
- **Swagger** está accesible sin autenticación (solo para documentación).
- Los **endpoints protegidos** requieren un token JWT válido con roles autorizados (`ADMIN`, `ESTUDIANTE`, `DOCENTE`).

---

## 📩 Contacto

Desarrollado por **Genesis Jalid Tapia Cortez**  
Proyecto para la materia **DESARROLLO WEB BACKEND – TAW-251**  
Gestión 2025


