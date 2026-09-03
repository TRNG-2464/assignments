# Activity — Character Counter

This browser project implements Postly’s live caption counter in three separate files. It provides normal, near-limit, and over-limit states; allows typing past the limit in its base mode; and includes the requested hard-limit checkbox stretch goal.

## Project files and launch

The project targets **JavaScript using ES2026-compatible syntax** in a modern browser and is compatible with **Node.js 24.19.0** tooling where JavaScript syntax checks are desired. No external dependencies or build process are required.

| File | Responsibility |
|---|---|
| `index.html` | Provides the caption textarea, live counter, clear button, and hard-limit checkbox. |
| `style.css` | Styles the layout and the three visually distinct counter states. |
| `script.js` | Stores the adjustable limit variables and handles all behavior with event listeners. |

Open `index.html` in a modern browser to run the project. It begins with an empty caption and a normal-state counter reading **`0 / 280`**.

## Required interaction

The counter updates on every text input. At **260 characters or more**, it switches to the warning style; above **280 characters**, it changes to the over-limit style while still accepting input. Clicking **Clear** empties the textarea and restores `0 / 280` to the normal state. When **Prevent typing past limit** is checked, text is limited to 280 characters; if it is enabled after a longer caption already exists, the caption is trimmed to the limit immediately.
