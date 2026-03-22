# 💳 Ejercicio: Cajero Automático en Java

## 📌 Enunciado

Desarrolla una aplicación en Java que simule un cajero automático por consola.

El sistema debe permitir a un usuario autenticarse mediante número de cliente y PIN, y realizar operaciones sobre dos tipos de cuentas.

---

## 🎯 Requisitos

### 🔐 Autenticación

* Solicitar número de cliente y PIN
* Validar contra una estructura de datos (ej: HashMap)

---

### 🧾 Cuentas

* Cuenta principal
* Cuenta de ahorros

---

### 💰 Operaciones

Para cada cuenta:

* Consultar saldo
* Ingresar dinero
* Retirar dinero (si hay saldo suficiente)

---

### 📋 Navegación

* Menús por consola
* Permitir volver atrás
* El programa no debe cerrarse tras cada operación

---

## ⚠️ Restricciones

* No usar base de datos
* Controlar errores de entrada
* No permitir cantidades negativas

---

## 🧠 Pistas

* Usa `Scanner` para entrada
* Usa `HashMap` para usuarios
* Separa lógica y menú en clases distintas

---

## 🚀 Extra

* Persistencia en fichero
* Interfaz gráfica
* Tests unitarios