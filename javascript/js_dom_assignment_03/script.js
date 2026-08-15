const taskForm = document.getElementById("task-form");
const taskInput = document.getElementById("task-input");
const taskList = document.getElementById("task-list");
const taskCounter = document.getElementById("task-counter");

function updateTaskCounter() {
  const incompleteTasks = taskList.querySelectorAll(
    ".task-item:not(.completed)"
  ).length;

  const word = incompleteTasks === 1 ? "task" : "tasks";

  taskCounter.textContent = `${incompleteTasks} ${word} left`;
}

function addTask(taskText) {
  const listItem = document.createElement("li");
  listItem.classList.add("task-item");

  const checkbox = document.createElement("input");
  checkbox.type = "checkbox";

  const text = document.createElement("span");
  text.classList.add("task-text");
  text.textContent = taskText;

  const deleteButton = document.createElement("button");
  deleteButton.type = "button";
  deleteButton.classList.add("delete-button");
  deleteButton.textContent = "Delete";

  checkbox.addEventListener("change", () => {
    listItem.classList.toggle("completed", checkbox.checked);
    updateTaskCounter();
  });

  deleteButton.addEventListener("click", () => {
    listItem.remove();
    updateTaskCounter();
  });

  listItem.appendChild(checkbox);
  listItem.appendChild(text);
  listItem.appendChild(deleteButton);

  taskList.appendChild(listItem);

  updateTaskCounter();
}

taskForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const taskText = taskInput.value.trim();

  if (taskText === "") {
    return;
  }

  addTask(taskText);

  taskInput.value = "";
  taskInput.focus();
});