
const taskInputText = document.getElementById('task-input-text');
const taskInputButton = document.getElementById('task-input-btn');
const taskCounter = document.getElementById('task-counter');
const taskList = document.getElementById('task-list');

function updateCounter() {
    let tasks = taskList.querySelectorAll('.task');
    let completedTasks = taskList.querySelectorAll('.task.completed');
    let taskCount = tasks.length - completedTasks.length;
    taskCounter.textContent = `Tasks Left: ${taskCount}`;
}

updateCounter();

function completeButtonOnChange(event) {
    let taskEntry = event.target.parentElement;
    let taskLabel = taskEntry.querySelector('.task');

    if (event.target.checked) {
        taskLabel.classList.add('completed');
    } else {
        taskLabel.classList.remove('completed');
    }

    updateCounter();
}

function deleteButtonOnClick(event) {
    console.log(event.target.parentElement);

    let task = event.target.parentElement;
    task.remove();
    updateCounter();
}

function createTask(text) {
    let li = document.createElement('li');
    taskList.appendChild(li);
    li.innerHTML = `
        <h1 class="task">${text}</h1>
        <input type="checkbox" class="completion-btn">
        <span>Complete</span>
        <button>Delete</button>
        `;

    let completion = li.querySelector('input');

    let deletion = li.querySelector('button');

    completion.addEventListener('change', completeButtonOnChange);
    deletion.addEventListener('click', deleteButtonOnClick);


    updateCounter();
}

taskInputButton.addEventListener('click', (event) => {
    let taskText = taskInputText.value;
    if (taskText.length == 0) return;

    createTask(taskText);
})
