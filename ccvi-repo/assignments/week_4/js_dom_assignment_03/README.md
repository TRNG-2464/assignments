# Activity — To-Do List

This browser project implements Tasklyst’s one-page task manager in separate HTML, CSS, and JavaScript files. Tasks are created dynamically, completion and deletion controls update the live incomplete-task counter, and both requested stretch goals are included: clear completed tasks and All/Active/Completed filters.

## Project files and launch

The project targets **JavaScript using ES2026-compatible syntax** in a modern browser and is compatible with **Node.js 24.19.0** tooling where JavaScript syntax checks are desired. It has no external dependencies or build process.

| File | Responsibility |
|---|---|
| `index.html` | Provides the form, counter, filter controls, clear-completed button, and empty list container. |
| `style.css` | Styles the responsive task interface, completed tasks, hidden filtered tasks, and focus states. |
| `script.js` | Dynamically creates tasks and implements every required interaction. |

Open `index.html` in a modern browser to run the project. The page begins with an empty task list and **`0 tasks left`**.

## Required interaction

Enter **Buy groceries** and either click **Add task** or press Enter. A dynamic task item appears, the input clears, and the counter changes to **`1 task left`**. The checkbox applies a completed strikethrough and removes the task from the incomplete count; each **Delete** button removes only its own task. Whitespace-only form submissions are ignored. **Clear completed** removes every completed task. The **All**, **Active**, and **Completed** buttons change visibility only; they never delete or alter task data.
