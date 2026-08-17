const addForm = document.getElementById("add-form");
const taskInput = document.getElementById("task-input");
const taskList = document.getElementById("task-list");
const taskCounter = document.getElementById("task-counter");

function updateCounter() {
    // Count how many .task items do NOT have the "completed" class.
    // Update taskCounter text, e.g. "3 tasks left"
    const remaining = taskList.querySelectorAll(".task:not(.completed)").length;
    taskCounter.textContent = remaining + " tasks left";
}

function addTask(text) {
    // Create a <li class="task"> with:
    //   - a checkbox to toggle "completed" on this li
    //   - a <span class="task-text"> for the task text
    //   - a delete button that removes only this li
    // Append it to taskList, then call updateCounter().
    const li = document.createElement("li");
    li.classList.add("task");

    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    const span = document.createElement("span");
    span.classList.add("task-text");
    span.textContent = text;
    const deleteButton = document.createElement("button");
    deleteButton.type = "button";
    deleteButton.textContent = "Delete";

    li.appendChild(checkbox);
    li.appendChild(span);
    li.appendChild(deleteButton);
    taskList.appendChild(li);
    updateCounter();
    // inside so that their effects affect "this" element (borrowing the Java def of "this")
    checkbox.addEventListener("click", () => {
        li.classList.toggle("completed");
        updateCounter();
    });
    
    deleteButton.addEventListener("click", () => {
        li.remove();
        updateCounter();
    });
}



addForm.addEventListener("submit", (event) => {
    event.preventDefault(); // stop the page from reloading

    const text = taskInput.value.trim(); // use value not .textContent because <input> is a self closing tag

    // Ignore blank / whitespace-only submissions.
    if (text.length === 0) return;
    // Add the task, then clear the input.
    addTask(text);
    taskInput.value = "";
});

updateCounter();
