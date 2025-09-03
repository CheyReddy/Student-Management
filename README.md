🎓 StudentApp Management

A Spring Boot web application + REST API for managing students and administrators.

✨ Features

✅ Add, update, and delete students
✅ Add, update, and delete admins
✅ View all students and admins in tables (JSP UI)
✅ REST API endpoints for students and admins
✅ Form validation
✅ Spring MVC + JSP pages
✅ Styled dashboards with CSS
✅ Swagger UI (OpenAPI) integration for API documentation

🚀 Getting Started
Prerequisites

Java 8 or higher

Maven

MySQL (or your configured database)

Clone the Repository
git clone https://github.com/CheyReddy/Student-Management.git
cd Student-Management

Run the Application
mvn spring-boot:run

🌐 Web Interface

Student & Admin management available via JSP pages.

Default entry point: http://localhost:8080

🔗 REST APIs
Base URL
http://localhost:8080/api/students
http://localhost:8080/api/admins

Example Endpoints

GET /api/students → Get all students

GET /api/students/{id} → Get student by ID

POST /api/students → Add a new student

PUT /api/students/{id} → Update student

DELETE /api/students/{id} → Delete student

(Same structure for admins under /api/admins)

📖 API Documentation (Swagger UI)

Once the application is running, open:

👉 http://localhost:8080/swagger-ui/index.html

You’ll see all Student/Admin API endpoints with interactive documentation.

🛠 Tech Stack

Spring Boot

Spring MVC

MySQL + Spring JDBC

JSP + CSS (frontend views)

Swagger/OpenAPI for API docs
