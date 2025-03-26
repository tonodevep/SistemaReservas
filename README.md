# Sistema de Reservas de Habitaciones de Hotel

## Objetivo
El objetivo de este proyecto es desarrollar un sistema de gestión de reservas de habitaciones de un hotel, utilizando Java y aplicando el patrón de diseño Modelo-Vista-Controlador (MVC). Este sistema permite administrar habitaciones, clientes y reservas de forma eficiente, incorporando las prácticas aprendidas previamente.

El código será gestionado mediante Git y alojado en un repositorio de GitHub.

---

## Estructura del Hotel

El hotel cuenta con **3 plantas**, cada una con 5 habitaciones numeradas de la siguiente forma:
- **Planta 1:** Habitaciones 101 a 105
- **Planta 2:** Habitaciones 201 a 205
- **Planta 3:** Habitaciones 301 a 305

### Tipos de habitaciones y precios:
- **INDIVIDUAL:** 50€ por noche
- **DOBLE:** 80€ por noche
- **SUITE:** 150€ por noche

Cada habitación tendrá un número único, un tipo, un precio por noche y un estado.

---

## Funcionalidades Principales

### Gestión de Habitaciones
Cada habitación incluye:
- Un número único de habitación (Ejemplo: 101, 202, etc.).
- Un tipo (`INDIVIDUAL`, `DOBLE`, `SUITE`).
- Un precio por noche según el tipo.
- Un estado (`DISPONIBLE`, `RESERVADA`, `OCUPADA`).
- Una descripción opcional (Ejemplo: "Vista al mar", "Cama King Size").

### Gestión de Clientes
Cada cliente tiene:
- Un **ID único**.
- Un **nombre completo**.
- Un historial de reservas anteriores.
- Un máximo de **3 reservas activas** al mismo tiempo.

### Gestión de Reservas
Cada reserva contiene:
- Un **ID único** de la reserva.
- La habitación reservada.
- El cliente que realizó la reserva.
- Fechas de **check-in** y **check-out**.
- Precio total calculado en función del número de noches y el precio por noche de la habitación.

---

## Estructura del Proyecto

Este proyecto sigue el patrón de diseño **Modelo-Vista-Controlador (MVC)**:
- **Modelo:** Clases que representan los datos (Habitación, Cliente, Reserva).
- **Vista:** Interfaces o salidas para interactuar con el usuario.
- **Controlador:** Lógica para manejar las interacciones entre la vista y el modelo.

### Requisitos Técnicos
1. **Lenguaje:** Java  
2. **Gestión del código:** Git  
3. **Alojamiento del repositorio:** GitHub  
4. **Estructura:** Usar el patrón MVC  

---

## Ejemplo de Uso

### Crear una reserva:
- Selecciona una habitación disponible.
- Registra los datos del cliente.
- Ingresa las fechas de check-in y check-out.
- Calcula automáticamente el precio total de la reserva.

### Ver el estado de las habitaciones:
- Consulta las habitaciones disponibles, reservadas u ocupadas en tiempo real.

---

## Autores
Este proyecto ha sido desarrollado por Sara Alonso Perdomo y Juan Antonio "Toño" Tejera González.  

Github Sara: [![Web](https://img.shields.io/badge/GitHub-juniuun-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/juniuun/)

Github de Toño: [![Web](https://img.shields.io/badge/GitHub-tonodevep-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/tonodevep/)



