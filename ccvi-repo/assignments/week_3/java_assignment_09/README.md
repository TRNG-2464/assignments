# Home Tour

## Overview
Home Tour is a text-based adventure game built in Java. The project demonstrates the combination of a command-parsing loop with an object-oriented state model. Players can navigate through interconnected rooms, interact with various entities, and manage a personal inventory. 

## Features
- **Interactive Map:** Explore a house with multiple interconnected rooms using directional commands (north, south, east, west, up, down).
- **Entity Interaction:** Engage with items within the house using the `interact` command.
- **Inventory System (Stretch Goal):** Pick up portable items using the `take` command and view your current collection with the `inventory` command.
- **Robust Error Handling:** Utilizes custom exceptions (`InvalidDirectionException`, `EntityNotFoundException`, `UntakeableEntityException`) to gracefully handle invalid actions without crashing the game.

## Prerequisites
- **Java Development Kit (JDK):** Version 21 or higher is required to support the modern Java syntax and features used in this project.

## How to Play

1. **Compile the code:**
   Open your terminal in the project directory and run:
   ```bash
   javac HomeTour.java
   ```

2. **Run the program:**
   ```bash
   java HomeTour
   ```

## Game Commands
The command parser is fully case-insensitive. 

- `move [direction]`: Moves the player to a connected room in the specified direction (e.g., `move north`, `move up`).
- `look`: Re-displays the current room's name, description, and list of interactable entities.
- `interact [entity]`: Triggers the interaction response for the named entity. This works for items in the current room as well as items in your inventory. (e.g., `interact CoffeeMaker`).
- `take [item]`: Picks up a portable item from the current room and adds it to your inventory. Some items (like large furniture) cannot be taken. (e.g., `take Keys`).
- `inventory`: Lists all the items you have picked up and are currently carrying.
- `exit` / `quit`: Ends the game.

## Project Structure
- `HomeTour.java`: Contains the main game loop, input parsing, and initialization logic.
- `Room.java`: Represents a location in the house, maintaining state for exits and entities.
- `Entity.java`: A Java Record representing interactable objects, including their name, description, response, and a boolean flag determining if they can be picked up.
- Custom Exceptions: Distinct exception classes used to route specific gameplay errors cleanly to the user.
