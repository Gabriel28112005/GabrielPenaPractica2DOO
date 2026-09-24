# Product Catalog Manager (Java, Object-Oriented Design)

Console application written in Java that manages a catalog of electronics: brands, televisions and mobile phones. It was developed as a practice project (Práctica 2) for the Object-Oriented Development course at Universidad Alfonso X el Sabio (UAX). The code, identifiers and console messages are in Spanish.

## Features

- Register brands (name, country, revenue). Brand names are unique.
- Register televisions (price, brand, name, screen type, size in inches) and mobile phones (price, brand, name, operating system, RAM in GB). A device can only be added if its brand is already registered.
- Search for brands (by name and country), televisions and mobile phones (by all of their attributes).
- List brands sorted by revenue (descending) and devices sorted by brand name, price and name.
- Validate user input (negative values, empty fields, unknown enum values) and report errors through custom checked exceptions.

## Object-oriented design

- **Inheritance and polymorphism:** abstract class `Dispositivo` (device) extended by `Movil` and `Televisor`.
- **Enums:** `TipoPantalla` (screen type) and `TipoSistemaOperativo` (operating system).
- **Interface and implementation:** the console menu depends on the `Operaciones` interface, implemented by `OperacionesImpl`.
- **Value equality:** `equals()` and `hashCode()` are implemented in `Marca`, `Dispositivo`, `Movil` and `Televisor`, so devices can be compared and searched by value.
- **Custom checked exceptions:** one per operation (`exceptions` package).
- **Streams, lambdas and chained `Comparator`s** for searching and multi-criteria sorting.

## Project structure

```
src/
├── Main.java
├── models/        Marca, Dispositivo (abstract), Movil, Televisor, TipoPantalla, TipoSistemaOperativo
├── service/       Operaciones (interface)
├── serviceImpl/   OperacionesImpl
├── mvc/           Menu (console user interface)
├── exceptions/    Custom checked exceptions
└── umlDiagram/    PlantUML class, sequence and use-case diagrams
```

## UML diagrams

The `src/umlDiagram` folder contains three PlantUML files: a class diagram, a sequence diagram and a use-case diagram for the "add television" operation.

## How to run

Requires JDK 17 or later (developed with JDK 23).

**IntelliJ IDEA:** open the project folder and run `Main`.

**Command line (Linux, macOS or Git Bash):**

```
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out Main
```