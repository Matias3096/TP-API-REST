# TP API REST – Gestión de Productos (Spring Boot)

## 📌 Descripción
API REST completa para gestión de productos desarrollada con **Spring Boot 3.x**, **Java 21**, **H2** y **Swagger**.  
Incluye **arquitectura por capas**, **validaciones**, **manejo centralizado de errores** y **documentación automática**.

## 🚀 Tecnologías
- Java 21
- Spring Boot 3.5.7
- Spring Data JPA
- H2 Database (memoria)
- Swagger / OpenAPI 3
- Lombok
- Postman (testing)

## ▶️ Cómo ejecutar
1. Clonar el repositorio
2. Abrir con IntelliJ IDEA
3. Run `TpApiRestApplication`
4. Swagger UI: http://localhost:8080/swagger-ui/index.html
5. H2 Console: http://localhost:8080/h2-console (JDBC: `jdbc:h2:mem:productosdb`, user: `sa`, pass: )

## 📊 Endpoints probados
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/api/productos` | Listar todos |
| GET | `/api/productos/{id}` | Buscar por ID |
| GET | `/api/productos/categoria/{cat}` | Filtrar por categoría |
| POST | `/api/productos` | Crear producto |
| PUT | `/api/productos/{id}` | Actualizar completo |
| PATCH | `/api/productos/{id}/stock` | Actualizar solo stock |
| DELETE | `/api/productos/{id}` | Eliminar |

## 📸 Capturas de pruebas
* En carpeta capturas

## 👤 Autor
**Matias Fernandez** – UTN FRM
