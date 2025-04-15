# sistema-educativo-microservicios-Mialbo

Este proyecto es una evolución de un sistema educativo implementado con un enfoque de microservicios usando Spring Boot y Spring Cloud.

## 👤 Autor

Nombre: Miler Alexis Bolaños  
Correo: miler.bolanos@gmail.com.com  
Curso: Microservicios con Spring Boot

Objetivo del Proyecto

El objetivo es transformar un sistema monolítico en una arquitectura basada en microservicios independientes, escalables y desplegables, que se comuniquen entre sí mediante clientes REST.

Arquitectura General

El sistema está dividido en los siguientes microservicios:

- `usuarios-servicio`: Gestiona estudiantes y docentes.
- `asignaturas-servicio`: CRUD de materias.
- `matriculas-servicio`: Registra estudiantes en materias.
- `eureka-server`: Descubrimiento de servicios.

Cada microservicio tiene su propia base de datos, configuración, pruebas y despliegue.

Tecnologías

- Java 17
- Spring Boot
- Spring Cloud (Eureka, Feign, Config)
- JWT y Spring Security
- Docker y Docker Compose
- JUnit y Postman
