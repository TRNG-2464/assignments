# Activity — To-Do List

## Objective

Build a browser-based To-Do List using separate HTML, CSS, and JavaScript files. This activity focuses on **dynamically creating and removing DOM elements**, and practices `createElement`, `appendChild`, `.remove()`, form input handling, and `classList` toggling for state.

---

## Background

You've joined the team at **Tasklyst**, a small productivity app startup. Their flagship feature is a simple, no-frills task list that users can manage entirely on one page — no reloads, no page navigation. Your job is to build the core interactive list: adding tasks, marking them complete, removing them, and keeping the user informed of how much is left to do.

---

## Scenario / Problem Statement

Build a page with a text input for entering new tasks and a running list of tasks below it. Each task the user adds should be created and inserted into the page dynamically — not hardcoded in the HTML. Users need to be able to mark a task as complete, delete a task entirely, and see at a glance how many tasks are still outstanding.

---

## Project Structure

This activity requires **three separate files**, properly linked together:

- `index.html` — page structure and markup
- `style.css` — all styling, linked via `<link>` in the HTML `<head>`
- `script.js` — all interactivity, linked via `<script>` at the end of the HTML `<body>`

---

## Requirements

- **Adding tasks**
  - A text input where the user types a new task
  - An "Add" button and/or Enter-key support to submit the task
  - Submitting creates a new task element in the DOM using `createElement`/`appendChild` — tasks must not be hardcoded in the HTML
  - The input field clears automatically after a task is successfully added
  - Blank or whitespace-only submissions should be ignored (no empty tasks added)

- **Task items**
  - Each task in the list displays its text
  - Each task includes a way to mark it complete (e.g. a checkbox, or clicking the task text) — toggles a "completed" visual style (e.g. strikethrough or muted color)
  - Each task includes a delete control (button/icon) that removes **only that specific task** from the DOM when clicked

- **Task counter**
  - A counter displayed on the page showing how many tasks are still incomplete (e.g. `"3 tasks left"`)
  - Updates automatically whenever a task is added, completed, uncompleted, or deleted

---

## Requirements Checklist

- Three separate files: `index.html`, `style.css`, `script.js`, correctly linked
- Text input with an add mechanism (button and/or Enter key)
- New tasks are created via `createElement`/`appendChild`, not hardcoded in HTML
- Input clears after a successful add; blank/whitespace-only tasks are ignored
- Each task has a way to toggle "completed" styling
- Each task has a working delete control that removes only that task
- A live counter shows the number of incomplete tasks and updates on every relevant change
- All interactivity handled via `addEventListener` in `script.js` (no inline event handlers)

---

## Example Interaction

- Page loads with an empty task list and a counter reading `"0 tasks left"`
- User types "Buy groceries" and clicks **Add** (or presses Enter)
  - A new task item appears in the list, the input clears, and the counter updates to `"1 task left"`
- User adds two more tasks — counter now reads `"3 tasks left"`
- User clicks the checkbox on "Buy groceries" — the task text gets a strikethrough style, and the counter updates to `"2 tasks left"`
- User clicks the delete control on a different task — that task is removed from the list, and the counter updates accordingly
- User tries to submit a blank task — nothing is added, counter is unchanged

---

## Stretch Goals

Once the core functionality is working, try adding these as separate additions to your existing code:

1. **Clear Completed button** — add a button that, when clicked, removes all currently completed tasks from the list at once, leaving incomplete tasks untouched. Update the task counter accordingly.

2. **Filter buttons (All / Active / Completed)** — add three buttons that let the user switch which tasks are visible: all tasks, only incomplete ("active") tasks, or only completed tasks. This should only affect which tasks are shown/hidden (e.g. via a CSS class) — it should not delete or alter any task data.
