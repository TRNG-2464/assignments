const taskInput = document.getElementById('taskInput');
const addBtn = document.getElementById('addBtn');
const taskList = document.getElementById('taskList');
const counter = document.getElementById('counter');

function updateCounter() {
    const remaining = taskList.querySelectorAll('.task-text:not(.completed)').length;
    counter.textContent = `${remaining} task${remaining === 1 ? '' : 's'} left`;
}

function addTask() {
    const text = taskInput.value.trim();
    if (text === '') return;

    const li = document.createElement('li');

    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.addEventListener('change', () => {
        taskText.classList.toggle('completed');
        updateCounter();
    });

    const taskText = document.createElement('span');
    taskText.className = 'task-text';
    taskText.textContent = text;

    const deleteBtn = document.createElement('button');
    deleteBtn.className = 'delete-btn';
    deleteBtn.textContent = '✕';
    deleteBtn.addEventListener('click', () => {
        li.remove();
        updateCounter();
    });

    li.appendChild(checkbox);
    li.appendChild(taskText);
    li.appendChild(deleteBtn);
    taskList.appendChild(li);

    taskInput.value = '';
    updateCounter();
}

addBtn.addEventListener('click', addTask);

taskInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
        addTask();
    }
});
