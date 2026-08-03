# Home Tour

## Objective

Practice combining a command-parsing loop with an object-oriented model of state — rooms connected to each other, entities that can be interacted with, and custom exceptions used to represent invalid game actions in a meaningful way.

## Instructions

- **Entities:** Define an `Entity` class representing an interactable object in a room (for example, a Coffee Maker or a Coat Rack). Each `Entity` should have, at minimum, a name, a description, and a way to produce a response when interacted with (for example, an `interact()` method that returns a `String`). To keep command parsing straightforward, entity names should be a **single word** (for example, "CoatRack" or "Coffeemaker" rather than "Coat Rack" or "Coffee Maker").

- **Rooms:** Define a `Room` class (or classes) representing a location in the house. Each room needs a name, a description, a set of directional exits to other rooms, and a list of `Entity` objects present in that room. There are two reasonable design patterns you could use here — either is acceptable for this activity:
  - **Pattern A — Single `Room` class, data-driven.** One `Room` class whose instances differ only by the data they are constructed with (different names, descriptions, exits, and entity lists per instance). This is the simpler approach, and works well if every room behaves the same way mechanically.
  - **Pattern B — Room class hierarchy.** An abstract `Room` base class with subclasses for rooms that behave differently in some way — for example, a `Basement` subclass that requires a light to be turned on before its full description is shown, or an `Attic` that requires an item to access. This mirrors the abstract-class pattern from the Zoo Animal Sound Board activity, and is a good option if you want room-specific behavior beyond just differing data.

- **House layout:** Build a house with a minimum of 4 connected rooms, wired together with directional exits (north/south/east/west/up/down). The specific layout — which rooms, how they connect, and what entities are in each — is up to you, as long as there are at least 4 rooms and the connections are consistent (for example, if the Kitchen has an exit south to the Foyer, the Foyer should have a corresponding exit north back to the Kitchen).

- **Command loop:** Using `Scanner`, prompt the user for a command in a loop. Support at minimum:
  - `move [direction]` — moves the player to the connected room in that direction, if one exists
  - `look` — re-displays the current room's description and its entities
  - `interact [entity name]` — interacts with the named entity in the current room, if it exists, and displays the result
  - `exit` / `quit` — ends the program
  - Entering a new room (including the very first room at program start) should always display that room's name, description, and its entities.
  - All commands (including direction and entity name arguments) should be treated **case-insensitively** — for example, `MOVE NORTH`, `move north`, and `Move North` should all behave identically.

- **Custom Exceptions:** Define and use at least two custom exception classes (extending `Exception` or `RuntimeException`) to represent invalid game actions, rather than relying solely on printed error messages inline. For example:
  - An `InvalidDirectionException`, thrown when a `move` command specifies a direction with no exit from the current room
  - An `EntityNotFoundException`, thrown when an `interact` command references an entity that is not present in the current room

  These exceptions should be thrown from the relevant logic (for example, from a method that resolves a direction to a room, or resolves an entity name to an `Entity`), and caught within the command loop, where a clear message is displayed to the user. The game should continue running after an exception is caught — it should not crash or exit.

## Example Interactions

```
You are in the Foyer.
A small entryway with a coat rack and a stairway leading up.
Interactable entities: CoatRack

Enter a command: interact CoatRack
You check the CoatRack. There's an old raincoat hanging on it.

Enter a command: move north
You are in the Kitchen.
A bright kitchen with the smell of fresh coffee.
Interactable entities: CoffeeMaker, Refrigerator

Enter a command: move west
Error: There is no exit to the west from here.

Enter a command: interact Toaster
Error: There is no 'Toaster' here to interact with.

Enter a command: exit
Thanks for visiting! Goodbye.
```

## Requirements Checklist

- [ ] `Entity` class is defined with at least a name, a description, and an interaction response
- [ ] Entity names are single words, with no spaces
- [ ] `Room` class (or class hierarchy) is defined with a name, description, exits, and entities, using either Pattern A or Pattern B
- [ ] At least 4 rooms exist and are connected consistently (exits go both ways between connected rooms)
- [ ] `move [direction]` correctly moves the player between connected rooms
- [ ] `look` correctly re-displays the current room's description and entities
- [ ] `interact [entity name]` correctly triggers the named entity's interaction response
- [ ] `exit` / `quit` correctly ends the program with a farewell message
- [ ] All commands, directions, and entity name arguments are handled case-insensitively
- [ ] At least two custom exception classes are defined (for example, `InvalidDirectionException` and `EntityNotFoundException`)
- [ ] Custom exceptions are thrown from appropriate logic, rather than only checked with `if` statements and printed directly
- [ ] Custom exceptions are caught within the command loop, displaying a clear message, without crashing or exiting the program
- [ ] Entering a new room (including the starting room) always displays its name, description, and entities
- [ ] Code is organized into separate classes (`Entity`, `Room`, and any others needed) rather than crammed into `main`

## Stretch Goals

This stretch goal may require modifying your existing command-handling logic to accommodate new commands — unlike some earlier activities, this addition is expected to integrate with your original solution rather than remain fully separate, given the scope of this activity.

- **Inventory and the `take` Command** — Add support for a `take [item]` command, allowing the player to pick up certain entities from a room (you'll need to decide which entities, if any, should not be takeable, such as large furniture). Maintain a player inventory of taken entities, and add an `inventory` command that lists everything the player currently has. Consider what should happen if the player tries to `take` an entity that isn't takeable, or `interact` with an entity they've already taken and removed from the room.
