# Activity — Character Counter

## Objective

Build a browser-based Character Counter tool using separate HTML, CSS, and JavaScript files. This activity focuses on **live DOM updates driven by user input**, and practices `input` event listeners, conditional class/style changes based on state, and basic element resetting.

---

## Background

You've joined the product team at **Postly**, a social media scheduling tool. When users draft a caption, they need to know exactly how many characters they've used against the platform's limit — similar to the live counters seen on sites like Twitter/X. The team wants a simple, reusable caption box: a text area with a live character counter that visually warns the user as they approach the limit, and clearly flags it if they go over.

---

## Scenario / Problem Statement

Build a page with a caption textarea and a live character counter displayed nearby. As the user types, the counter should update on every keystroke to show how many characters have been used out of a defined maximum. The counter should visually change appearance as the user approaches the limit, and again if they exceed it. Users should also be able to clear the textarea and reset the counter with a single button.

---

## Project Structure

This activity requires **three separate files**, properly linked together:

- `index.html` — page structure and markup
- `style.css` — all styling, linked via `<link>` in the HTML `<head>`
- `script.js` — all interactivity, linked via `<script>` at the end of the HTML `<body>`

---

## Requirements

- **Caption input**
  - A `<textarea>` where the user types their caption
  - A defined maximum character limit, stored as an easily adjustable variable in `script.js` (e.g. `280`)

- **Live counter**
  - A counter element displayed near the textarea, showing the current character count against the max (e.g. `"42 / 280"`)
  - Updates on every keystroke using an `input` event listener — no button required to trigger an update

- **Visual states**
  - **Normal** — default appearance while well under the limit
  - **Warning** — a visually distinct style (e.g. orange/yellow text) when the user is within a set number of characters of the limit (e.g. the last 20 characters before the max)
  - **Over limit** — a visually distinct style (e.g. red text) once the character count exceeds the max. Typing should still be allowed in this base version — the user is only warned, not blocked

- **Clear button**
  - A button that, when clicked, empties the textarea completely
  - Clearing the textarea should also reset the counter and its visual state back to normal

---

## Requirements Checklist

- Three separate files: `index.html`, `style.css`, `script.js`, correctly linked
- `<textarea>` element for caption entry
- Max character limit defined as an adjustable variable in `script.js`
- Counter updates live via an `input` event listener, displayed as "current / max"
- Distinct visual states for: normal, near-limit warning, over-limit
- Clear button empties the textarea and resets the counter/visual state
- All interactivity handled via `addEventListener` in `script.js` (no inline event handlers)

---

## Example Interaction

- Page loads with an empty textarea and a counter reading `"0 / 280"` in its normal state
- User types a caption; the counter updates on every keystroke, e.g. `"137 / 280"`
- As the user's text passes 260 characters, the counter switches to its warning style (still counting up normally)
- If the user keeps typing past 280 characters, the counter switches to its over-limit style, e.g. `"289 / 280"`, and typing is still allowed
- User clicks the **Clear** button — the textarea empties and the counter resets to `"0 / 280"` in its normal state

---

## Stretch Goal

Once the core functionality is working, try adding this as a separate addition to your existing code:

1. **Hard limit mode** — add a checkbox labeled something like "Prevent typing past limit." When checked, the textarea should stop accepting further input once the character count reaches the max (the user simply can't type more, rather than seeing an over-limit warning). When unchecked, the textarea should return to the original soft-warning behavior, allowing the user to exceed the limit.
