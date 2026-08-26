
// Select elements from the HTML
const taskForm = document.getElementById("taskForm");
const taskInput = document.getElementById("taskInput");
const taskList = document.getElementById("taskList");
const taskCounter = document.getElementById("taskCounter");

// Add a new task when the form is submitted
taskForm.addEventListener("submit", function (event) {

    // Prevent the page from refreshing
    event.preventDefault();

    // Get the task text and remove extra whitespace
    const taskText = taskInput.value.trim();

    // Ignore blank tasks
    if (taskText === "") {
        return;
    }

    // Create the task list item
    const taskItem = document.createElement("li");
    taskItem.classList.add("task-item");

    // Create the checkbox
    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.classList.add("task-checkbox");

    // Create the task text
    const taskTextElement = document.createElement("span");
    taskTextElement.classList.add("task-text");
    taskTextElement.textContent = taskText;

    // Create the delete button
    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.classList.add("delete-button");

    // Add checkbox, text, and delete button to the task
    taskItem.appendChild(checkbox);
    taskItem.appendChild(taskTextElement);
    taskItem.appendChild(deleteButton);

    // Add the complete task to the task list
    taskList.appendChild(taskItem);

    // Clear the input field
    taskInput.value = "";

    // Update the counter
    updateTaskCounter();

    // Put the cursor back in the input
    taskInput.focus();

    // Mark task as completed/uncompleted
    checkbox.addEventListener("change", function () {

        taskItem.classList.toggle("completed");

        updateTaskCounter();
    });

    // Delete this specific task
    deleteButton.addEventListener("click", function () {

        taskItem.remove();

        updateTaskCounter();
    });
});


// Update the number of incomplete tasks
function updateTaskCounter() {

    // Get all task items
    const tasks = document.querySelectorAll(".task-item");

    // Start the incomplete task count at zero
    let incompleteTasks = 0;

    // Check every task
    tasks.forEach(function (task) {

        if (!task.classList.contains("completed")) {
            incompleteTasks++;
        }
    });

    // Display the correct message
    if (incompleteTasks === 1) {
        taskCounter.textContent = "1 task left";
    } else {
        taskCounter.textContent = `${incompleteTasks} tasks left`;
    }
}