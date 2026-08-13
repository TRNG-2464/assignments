# Activity — Color Switcher

## Objective

Build a browser-based Color Switcher tool using separate HTML, CSS, and JavaScript files. This activity focuses on **DOM manipulation and event handling**, and practices `addEventListener`, DOM selection (`querySelector`/`getElementById`), `classList` toggling, and inline style updates.

---

## Background

You've joined the web team at **Hue & Home**, a paint company that wants a simple "mood swatch" widget for their site. Customers often can't picture how a paint color will look on their wall just from a small swatch, so the design team wants an interactive preview tool: visitors click a color swatch, and a large preview area updates to show that color, along with its exact color value — helpful for anyone who wants to note it down before ordering a sample.

---

## Scenario / Problem Statement

Build a page with a row of color swatch buttons and a large preview area. Each swatch button should be labeled with its color's name and should itself be styled in that color, so customers can see the option and its name together. Clicking a swatch updates the preview area to that color and displays the color's value as text. Only one swatch should appear "selected" at a time.

---

## Project Structure

This activity requires **three separate files**, properly linked together:

- `index.html` — page structure and markup
- `style.css` — all styling, linked via `<link>` in the HTML `<head>`
- `script.js` — all interactivity, linked via `<script>` at the end of the HTML `<body>`

---

## Requirements

- **Swatch buttons**
  - Implement each color option as a `<button>` element (not a `div`)
  - Each button's text content should display the **name** of its color (e.g. "Ocean Blue", "Sunset Orange")
  - Each button's own background color should match its associated color, so the button doubles as a visual sample
  - Include **at least 5** distinct color swatches

- **Preview area**
  - A dedicated element on the page whose background color updates to match the most recently clicked swatch
  - A text element near the preview area that displays the current color's value (hex or RGB), updating whenever the preview color changes

- **Selection state**
  - The currently selected swatch button should be visually distinguished from the others (e.g. a highlighted border or outline)
  - Only one swatch should appear selected at a time — selecting a new swatch should remove the indicator from the previous one

- **Interactivity**
  - Use `addEventListener('click', ...)` on each swatch button to trigger the update logic
  - All DOM updates should happen in `script.js` — no inline `onclick` attributes in the HTML

---

## Requirements Checklist

- Three separate files: `index.html`, `style.css`, `script.js`, correctly linked
- At least 5 swatch buttons (`<button>` elements, not `div`s)
- Each swatch button displays its color's name as text
- Each swatch button's background color matches its associated color
- Clicking a swatch updates the preview area's background color
- Clicking a swatch updates a text element showing the color's hex or RGB value
- Only one swatch shows a "selected" indicator at a time
- All interactivity handled via `addEventListener` in `script.js` (no inline event handlers)

---

## Example Interaction

- Page loads showing 5+ color swatch buttons, each labeled with a color name and colored accordingly, plus an empty/default preview area
- User clicks the **"Ocean Blue"** button
  - The preview area's background turns blue
  - The value text updates to display something like `#1E5AA8`
  - The "Ocean Blue" button shows a highlighted border; no other button does
- User clicks **"Sunset Orange"**
  - The preview area updates to orange, the value text updates accordingly
  - The highlighted border moves from "Ocean Blue" to "Sunset Orange"

---

## Stretch Goals

Once the core functionality is working, try adding these as separate additions to your existing code:

1. **Random Color button** — add a button that, when clicked, randomly selects one of the existing swatches and applies it exactly as if the user had clicked that swatch directly (preview color, value text, and selected-state indicator should all update accordingly).

2. **Custom Color input** — add an `<input type="color">` element that lets the user pick any color, not just the presets. Selecting a custom color should update the preview area and value text the same way a swatch click does. Decide how (or whether) this interacts with the swatch "selected" state.
