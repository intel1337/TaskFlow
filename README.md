# 📌 TaskFlow

TaskFlow is a collaborative **project management web application** inspired by Trello.  
It allows users to create projects, organize tasks in columns (Todo, In Progress, Done), and manage team workflows through a simple and modern interface.

---

## 🚀 Features

- Secure authentication with JWT  
- User management (admin / member roles)  
- Project creation and management  
- Customizable columns (Kanban workflow)  
- Task CRUD operations (create, edit, delete)  
- Task assignment to team members  
- Responsive and modern interface with drag & drop support  

---

## 🛠️ Tech Stack

### **Frontend** – [SvelteKit](https://kit.svelte.dev/)
- **SvelteKit + TypeScript** – modern frontend framework  
- **TailwindCSS** – fast and responsive styling  
- **TanStack Query** – API calls and caching  
- **Svelte stores** – global state management (auth, current project)  

### **Backend** – [Spring Boot](https://spring.io/projects/spring-boot)
- **Spring Boot 3** (Java 17+) – REST API  
- **Spring Security + JWT** – authentication and authorization  
- **Spring Data JPA (Hibernate)** – ORM for PostgreSQL  
- **Validation** (`jakarta.validation`) – input validation  
- **Unit testing** – JUnit 5, Mockito  

### **Database**
- **PostgreSQL** – reliable relational database  
- Main tables:  
  - `users` (id, email, password, role)  
  - `projects` (id, name, description, owner)  
  - `columns` (id, name, position, project_id)  
  - `tasks` (id, title, description, status, column_id, assigned_user_id)  

### **DevOps & Infrastructure**
- **Docker Compose (local)** – `frontend`, `backend`, `db`  
- **Kubernetes (production)**  
  - Separate deployments (`frontend`, `backend`, `postgres`)  
  - Services (ClusterIP, LoadBalancer)  
  - Ingress (Nginx + SSL via cert-manager)  
- **CI/CD (GitHub Actions)**  
  - Lint + unit tests → Docker build → deployment  
- **Monitoring (optional)** – Prometheus + Grafana  

---


