> **Note: Language Context**
>
> Please note that this project was written in **German** as part of my `Ausbildung` (German vocational training). Therefore, all variable names, comments, and console outputs (`System.out.println`) within the source code are in German.

---

# Java OOP Vehicle Fleet Simulation

## About This Project

This project is another comprehensive demonstration of core **Object-Oriented Programming (OOP)** principles in Java, similar to my `Java-OOP-Shapes` project. It models a diverse fleet of vehicles using a clean inheritance hierarchy and demonstrates polymorphism, abstraction, and interfaces.

The `FahrzeugApp.java` class simulates managing and using this fleet for various routes.

## Key OOP Concepts Demonstrated

### 1. Abstraction (`Fahrzeug.java`)

* The `abstract` base class `Fahrzeug` (Vehicle) defines common attributes (`owner`, `kilometerstand`, `averageSpeed`) and shared functionality (`fahren()`, `toString()`).
* The `Huppen()` (Honk) method is declared `abstract`, forcing each specific vehicle type to provide its own unique honk sound.

### 2. Inheritance (`extends Fahrzeug`)

* Concrete classes like `PKW` (Car), `LKW` (Truck), `Fahrrad` (Bicycle), and `LastenFahrrad` (Cargo Bike) inherit the base vehicle properties.
* `LastenFahrrad` also extends `Fahrrad`, showing multi-level inheritance.

### 3. Interfaces (`implements ITransportieren`)

* The `ITransportieren` interface defines a specific capability (`transport_Cargo()`).
* Only vehicles capable of transport (`LKW`, `LastenFahrrad`) implement this interface. This is a clean way to add specific behaviors without forcing them onto the base `Fahrzeug` class (demonstrating composition over inheritance).

### 4. Polymorphism (`FahrzeugApp.java`)

* The `main` method uses a `List<Fahrzeug>` to hold different types of vehicles.
* When iterating, it uses `instanceof` checks to call **type-specific methods**:
    * `vollgasFahren()` only on `PKW` instances.
    * `transport_Cargo()` only on instances that implement `ITransportieren`.
    * The `Huppen()` method, however, is called polymorphically – Java automatically calls the correct `Huppen()` implementation for each vehicle type.

### 5. Encapsulation & Robustness

* Class attributes are generally `protected` or `private`.
* Constructors include validation logic (e.g., checking seat count, wheel count) and throw `IllegalArgumentException` to prevent the creation of invalid vehicle objects.
* The `fahren
