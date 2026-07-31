# Zoo Animal Sound Board

## Objective

Practice defining a class hierarchy using an abstract base class, overriding behavior in multiple subclasses, and selecting/instantiating the correct subclass based on user input read in a loop.

## Instructions

- Define an abstract class named `Animal`. This class should declare (at minimum) two abstract methods:
  - `makeSound()` — returns or prints the animal's sound
  - `describe()` — returns or prints a short description specific to that animal
- Create at least three subclasses of `Animal` (for example, `Dog`, `Cat`, `Bird`), each providing its own implementation of `makeSound()` and `describe()`.
- Using `Scanner`, display a number-based menu of the available animals, along with an option to exit. For example:
  ```
  1. Dog
  2. Cat
  3. Bird
  0. Exit
  ```
- In a loop, prompt the user to enter a number corresponding to their selection.
  - If the user selects a valid animal number, instantiate the corresponding subclass and call its `makeSound()` and `describe()` methods to display animal-specific output, then show the menu again for another selection.
  - If the user enters `0`, print a farewell message and end the program.
  - If the user enters a number that does not correspond to any menu option, or a non-numeric value, handle this gracefully with a clear message, and show the menu again rather than crashing.
- Avoid duplicating shared logic across your subclasses where the abstract base class can hold it instead.

## Example Interactions

```
1. Dog
2. Cat
3. Bird
0. Exit
Enter your selection: 1
Woof! Woof!
The dog wags its tail excitedly and looks up at you.

1. Dog
2. Cat
3. Bird
0. Exit
Enter your selection: 3
Tweet! Tweet!
The bird tilts its head and hops along its perch.

1. Dog
2. Cat
3. Bird
0. Exit
Enter your selection: 5
'5' is not a valid selection. Please choose a number from the menu.

1. Dog
2. Cat
3. Bird
0. Exit
Enter your selection: 0
Goodbye! Thanks for visiting the zoo.
```

## Requirements Checklist

- [ ] `Animal` is defined as an abstract class with at least `makeSound()` and `describe()` as abstract methods
- [ ] At least three subclasses of `Animal` are implemented, each overriding both methods with animal-specific behavior
- [ ] A number-based menu is displayed, listing each animal option and an exit option (`0`)
- [ ] The loop continues showing the menu and accepting selections until the user chooses to exit
- [ ] A valid selection correctly instantiates the corresponding subclass and displays its sound and description
- [ ] An invalid selection (out-of-range number or non-numeric input) is handled gracefully, with a clear message, and does not crash the program
- [ ] Entering `0` ends the program with a farewell message
- [ ] Shared logic between subclasses is placed in the abstract `Animal` class rather than duplicated
- [ ] Code is organized into separate classes for `Animal` and each subclass, rather than combining all class logic into `main`

## Stretch Goals

Each stretch goal should be implemented as its own separate method or class addition — do not modify your original subclasses' core behavior to accommodate these; extend them instead.

- **Additional Animal Attributes** — Give each animal subclass at least one additional unique field beyond what's used in the base activity (for example, a `Dog` might have a `breed`, a `Bird` might have a `canFly` boolean), and incorporate this new information into that animal's `describe()` output.
- **Random Animal Selector** — Add a new menu option (for example, "Surprise Me") that randomly selects one of the available animals and displays its sound and description, instead of requiring the user to choose a specific one.
