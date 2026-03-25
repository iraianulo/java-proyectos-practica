# 🎁 Ejercicio: Amigo Invisible en Java

## 📌 Enunciado

Desarrolla una aplicación en Java que permita organizar un sorteo de amigo invisible por consola.

El programa debe permitir introducir participantes y generar automáticamente las asignaciones de regalo.

---

## 🎯 Requisitos

### 👥 Gestión de participantes

* Permitir introducir nombres de participantes
* Almacenar los nombres en una estructura dinámica
* Mostrar el número total de participantes

---

### 📋 Menú

El programa debe mostrar un menú con opciones:

* [1] Añadir participante
* [0] Finalizar e iniciar sorteo

---

### 🎲 Sorteo

Al finalizar:

* Mezclar aleatoriamente la lista de participantes
* Asignar a cada persona otra a la que regalar

Reglas:

* Nadie puede regalarse a sí mismo
* Todos deben tener exactamente un destinatario
* El último participante debe asignarse al primero

---

### ⚠️ Validaciones

* Debe haber al menos 2 participantes
* Controlar entradas inválidas
* Evitar errores de ejecución

---

## 🧠 Pistas

* Usa `ArrayList<String>` para almacenar nombres
* Usa `Collections.shuffle()` para mezclar la lista
* Recorre la lista con un bucle
* Piensa cómo hacer un “ciclo cerrado” (último → primero)

---

## 🚀 Extra (opcional)

* Evitar nombres duplicados
* Permitir eliminar participantes
* Mostrar resultados de forma individual (modo secreto)
* Exportar resultados a un fichero

---

## ✅ Objetivo

Practicar:

* Estructuras de datos (`ArrayList`)
* Algoritmos simples (mezcla y asignación)
* Control de flujo
* Interacción con el usuario