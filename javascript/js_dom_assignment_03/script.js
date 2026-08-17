let input = document.querySelector("#input");
let addbutton = document.querySelector("#addbutton");
let tasklist = document.querySelector("#tasklist");
let counter = document.querySelector("#counter");

function updateCounter() {
    let incomplete = document.querySelectorAll("input:not(:checked)").length;
    counter.textContent = `${incomplete} tasks left`;
}

function addTask() {
    let curVal = input.value.trim();
    if (!curVal) { return; }

    let checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.addEventListener("change", function() {
        taskText.classList.toggle("completed");
        updateCounter();
    });

    let taskText = document.createElement("span");
    taskText.textContent = curVal;

    let deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener("click", function() {
        taskItem.remove();
        updateCounter();
    });

    let taskItem = document.createElement("div");
    taskItem.appendChild(checkbox);
    taskItem.appendChild(taskText);
    taskItem.appendChild(deleteButton);
    tasklist.appendChild(taskItem);
    updateCounter();

    input.value = "";
}

addbutton.addEventListener("click", addTask);

input.addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        addTask();
    }
});