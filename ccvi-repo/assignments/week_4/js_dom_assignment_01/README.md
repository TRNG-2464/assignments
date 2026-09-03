# Activity — Color Switcher

This browser project implements an interactive paint-color preview for Hue & Home. It uses separate HTML, CSS, and JavaScript files, contains six preset button swatches, and implements both requested stretch goals: random preset selection and a custom color picker.

## Project files and launch

The project targets **JavaScript using ES2026-compatible syntax** in a modern browser and is compatible with **Node.js 24.19.0** tooling where JavaScript syntax checks are desired. It does not require installation or a build process.

| File | Responsibility |
|---|---|
| `index.html` | Provides semantic page structure, six swatch `<button>` elements, the preview, and stretch-goal controls. |
| `style.css` | Styles the color card, visual swatches, responsive layout, focus states, and selected state. |
| `script.js` | Handles every DOM update and event listener. |

Open `index.html` in a modern browser to run the project. The page initially shows a neutral preview and the message **Select a swatch**.

## Required interaction

Selecting **Ocean Blue** changes the preview to blue, displays `Ocean Blue · #1E5AA8`, and visibly selects only the Ocean Blue swatch. Selecting **Sunset Orange** moves the selected state and updates both preview color and value. The **Choose a random color** button triggers the same preset-selection behavior. Selecting a value with the custom color picker updates the preview and value, while clearing preset selection because the choice is not a predefined swatch.
