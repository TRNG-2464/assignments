// To-Do List
// Handles adding, completing, and deleting tasks, plus the live counter.

const taskForm = document.getElementById('taskForm');
const taskInput = document.getElementById('taskInput');
const taskList = document.getElementById('taskList');
const taskCounter = document.getElementById('taskCounter');

// Creates and appends a new task item to the list
function addTask(text) {
  const listItem = document.createElement('li');
  listItem.className = 'task-item';

  const checkbox = document.createElement('input');
  checkbox.type = 'checkbox';
  checkbox.addEventListener('change', () => {
    listItem.classList.toggle('completed', checkbox.checked);
    updateCounter();
  });

  const taskText = document.createElement('span');
  taskText.className = 'task-text';
  taskText.textContent = text;
  taskText.addEventListener('click', () => {
    checkbox.checked = !checkbox.checked;
    checkbox.dispatchEvent(new Event('change'));
  });

  const deleteBtn = document.createElement('button');
  deleteBtn.type = 'button';
  deleteBtn.className = 'delete-btn';
  deleteBtn.textContent = '✕';
  deleteBtn.setAttribute('aria-label', 'Delete task');
  deleteBtn.addEventListener('click', () => {
    listItem.remove();
    updateCounter();
  });

  listItem.append(checkbox, taskText, deleteBtn);
  taskList.appendChild(listItem);

  updateCounter();
}

// Updates the "N tasks left" counter
function updateCounter() {
  const incompleteCount = taskList.querySelectorAll('.task-item:not(.completed)').length;
  const label = incompleteCount === 1 ? 'task' : 'tasks';
  taskCounter.textContent = `${incompleteCount} ${label} left`;
}

taskForm.addEventListener('submit', (event) => {
  event.preventDefault();

  const text = taskInput.value.trim();
  if (text === '') {
    return;
  }

  addTask(text);
  taskInput.value = '';
  taskInput.focus();
});

updateCounter();
