# Spring Boot CRUD Application

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.8.1-orange)

## Resumen Funcional

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) desarrollada con **Spring Boot**. Está diseñada para gestionar datos almacenados en una base de datos relacional, utilizando **Spring Data JPA** para la interacción con la base de datos y **Spring Security** para la autenticación y autorización. Además, se incluye un sistema de validación de tokens JWT para proteger las rutas de la API.

## Estructura del Proyecto

El proyecto sigue una estructura estándar de aplicaciones Spring Boot:

- **`src/main/java`**: Contiene el código fuente de la aplicación.
  - **`com.roberto.curso.springboot.app.springboot_crud`**: Paquete principal de la aplicación.
  - **`security.filter.JwtValidationFilter`**: Implementa un filtro para validar tokens JWT.
- **`src/main/resources`**: Archivos de configuración y recursos estáticos.
- **`db_data/`**: Contiene datos y configuraciones relacionadas con la base de datos MySQL.
- **`target/`**: Carpeta generada automáticamente por Maven para los artefactos compilados.

## Tecnologías Utilizadas

### Lenguaje
- **Java 17**: El proyecto utiliza Java como lenguaje principal. La versión 17 se deduce del uso de dependencias modernas de Spring Boot.

### Frameworks
- **Spring Boot 3.4.4**: Framework principal para el desarrollo de la aplicación.
- **Spring Data JPA**: Para la interacción con la base de datos.
- **Spring Security**: Para la gestión de autenticación y autorización.
- **JWT (JSON Web Tokens)**: Para la autenticación basada en tokens.

### Librerías
- **Jackson**: Para la serialización y deserialización de objetos JSON.
- **io.jsonwebtoken (JJWT)**: Para la creación y validación de tokens JWT.

### Gestor de Paquetes
- **Maven 3.8.1**: Utilizado para la gestión de dependencias y el ciclo de vida del proyecto.

## Configuración de la Base de Datos

El proyecto utiliza **MySQL** como base de datos relacional. Los archivos relacionados con la configuración y los datos de la base de datos se encuentran en la carpeta `db_data/`.

## Características Principales

1. **CRUD Completo**: Permite crear, leer, actualizar y eliminar registros.
2. **Autenticación JWT**: Implementación de un filtro de validación de tokens JWT para proteger las rutas de la API.
3. **Integración con MySQL**: Gestión de datos mediante Spring Data JPA.
4. **Seguridad**: Uso de Spring Security para la protección de endpoints.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

- **Java 17** o superior.
- **Apache Maven 3.8.1** o superior.
- **MySQL** para la base de datos.

## Ejecución del Proyecto

1. Clona el repositorio en tu máquina local.
2. Configura las credenciales de la base de datos en el archivo `application.properties` (ubicado en `src/main/resources`).
3. Ejecuta el siguiente comando para compilar y ejecutar la aplicación:

   ```bash
   mvn spring-boot:run```
4. Accede a la aplicación en http://localhost:8080.

## Recursos Adicionales

- [Documentación oficial de Spring Boot](https://spring.io/projects/spring-boot)
- [Guía de Spring Data JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Guía de Spring Security](https://spring.io/guides/gs/securing-web/)

## Notas

- El nombre original del paquete `com.roberto.curso.springboot.app.springboot-crud` fue modificado a `com.roberto.curso.springboot.app.springboot_crud` debido a restricciones en los nombres de paquetes.
- Si necesitas personalizar el proyecto, consulta la sección de [Maven Parent overrides](HELP.md) para evitar herencias no deseadas en el archivo POM.