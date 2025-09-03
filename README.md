<img width="1603" height="773" alt="student-regd" src="https://github.com/user-attachments/assets/27f68dc4-5810-44af-9146-d21c14e35ab2" />
<img width="1602" height="762" alt="modify-student" src="https://github.com/user-attachments/assets/c89be6aa-3a73-417b-b7c1-2ec4396a94f5" />
<img width="1622" height="770" alt="modify-admin" src="https://github.com/user-attachments/assets/8c19f2de-b50f-4fc7-9d57-e8d1ffcae55c" />
<img width="1637" height="776" alt="login" src="https://github.com/user-attachments/assets/40834a0c-bc56-4d18-a7c2-7273d082a12a" />
<img width="1623" height="767" alt="fetch-students" src="https://github.com/user-attachments/assets/ded84931-71f2-44ce-964a-c3856bc44e19" />
<img width="1622" height="677" alt="fetch-admins" src="https://github.com/user-attachments/assets/dac199ee-907a-46ce-a761-dd75d31e5b45" />
<img width="1620" height="765" alt="dashboard" src="https://github.com/user-attachments/assets/27f443f3-08e1-45c1-a13c-0b7d7bfc3cb7" />
<img width="1618" height="771" alt="admin-regd" src="https://github.com/user-attachments/assets/679018dc-d9df-4580-ac5d-5e2d8e8cb308" />
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
