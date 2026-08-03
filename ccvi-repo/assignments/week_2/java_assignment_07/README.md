# Zoo Animal Sound Board

## Overview
The Zoo Animal Sound Board is an interactive command-line Java application that demonstrates fundamental object-oriented programming concepts, including abstract classes, inheritance, and polymorphism. Users can select different animals from a menu to hear their unique sounds and read a description of their behavior.

## Features
* **Interactive Menu:** A `Scanner`-based loop that allows users to repeatedly select animals until they choose to exit.
* **Modern Class Hierarchy:** Utilizes an `abstract sealed` base class (`Animal`) to enforce shared behavior while strictly restricting inheritance to permitted subclasses, allowing for secure and exhaustive control flow.
* **Concrete Subclasses:** Includes `final` implementations for `Dog`, `Cat`, and `Bird`, each providing unique string outputs.
* **Advanced Control Flow:** Employs Modern Java standard features, including Switch Expressions and Pattern Matching for `switch`, to streamline object instantiation and subclass-specific data extraction without explicit type casting.
* **Graceful Error Handling:** Catches invalid inputs (out-of-range numbers or non-numeric characters) and prompts the user again without crashing the application.

### Stretch Goals Implemented
* **Additional Animal Attributes:** Each animal subclass contains unique fields (e.g., a Dog's breed, a Cat's indoor/outdoor status, a Bird's flight capability) that dynamically alter their `describe()` output and are accessed via pattern matching.
* **Random Animal Selector:** Includes a "Surprise Me!" menu option that utilizes `java.util.Random` to dynamically select and display an animal without explicit user choice.

## Requirements
* **Java Development Kit (JDK):** Version 21 or higher is explicitly required to execute this application and leverage modern Java features.

## Getting Started

### 1. Compilation
Navigate to the directory containing the source code and compile the Java file:
```bash
javac ZooAnimalSoundBoard.java
```

### 2. Execution
Run the compiled class file to start the interactive menu:
```bash
java ZooAnimalSoundBoard
```

## Example Usage
```text
1. Dog
2. Cat
3. Bird
4. Surprise Me!
0. Exit
Enter your selection: 1
Woof! Woof!
The Golden Retriever wags its tail excitedly and looks up at you.
[Additional DB Info: Breed is Golden Retriever]

1. Dog
2. Cat
3. Bird
4. Surprise Me!
0. Exit
Enter your selection: 4
Surprise! You got animal option #2...

Meow! Meow!
The indoor cat purrs and rubs against your leg.
[Additional DB Info: Indoor status is true]
```
