const addForm = document.getElementById('addForm');
const taskInput = document.getElementById('taskInput');
const taskList = document.getElementById('taskList');
const counter = document.getElementById('counter');
const emptyState = document.getElementById('emptyState');

let nextTaskId = 0;

// Add a new task
addForm.addEventListener('submit', (event) => {
  // Prevent the form's default page reload/navigation.
  // This also means pressing Enter submits, with no extra code needed.
  event.preventDefault();
  addTask();
});

function addTask() {
  const text = taskInput.value.trim();

  // Ignore blank or whitespace-only submissions
  if (text === '') {
    return;
  }

  createTaskElement(text);

  taskInput.value = '';
  taskInput.focus();

  updateCounter();
  updateEmptyState();
}

// Build a single task <li> and insert it into the list
function createTaskElement(text) {
  const li = document.createElement('li');
  li.className = 'task-item';
  li.dataset.id = String(nextTaskId++);

  const checkBtn = document.createElement('button');
  checkBtn.type = 'button';
  checkBtn.className = 'task-check';
  checkBtn.setAttribute('aria-label', 'Mark task complete');

  const textSpan = document.createElement('span');
  textSpan.className = 'task-text';
  textSpan.textContent = text;

  const deleteBtn = document.createElement('button');
  deleteBtn.type = 'button';
  deleteBtn.className = 'task-delete';
  deleteBtn.setAttribute('aria-label', 'Delete task');
  deleteBtn.textContent = '×';

  // Clicking the checkbox OR the task text toggles completion
  checkBtn.addEventListener('click', () => toggleComplete(li));
  textSpan.addEventListener('click', () => toggleComplete(li));

  // Delete only removes this specific task's <li>
  deleteBtn.addEventListener('click', () => deleteTask(li));

  li.appendChild(checkBtn);
  li.appendChild(textSpan);
  li.appendChild(deleteBtn);

  taskList.appendChild(li);
}

// Toggle a task's completed state
function toggleComplete(li) {
  li.classList.toggle('is-completed');
  updateCounter();
}

// Remove a single task from the DOM
function deleteTask(li) {
  li.remove();
  updateCounter();
  updateEmptyState();
}

// Keep the "N tasks left" counter accurate
function updateCounter() {
  const incompleteCount = taskList.querySelectorAll('.task-item:not(.is-completed)').length;
  const label = incompleteCount === 1 ? 'task' : 'tasks';
  counter.textContent = `${incompleteCount} ${label} left`;
}

// Show/hide the "nothing on the list" message
function updateEmptyState() {
  const hasTasks = taskList.children.length > 0;
  emptyState.style.display = hasTasks ? 'none' : 'block';
}

// Initialize on page load
updateCounter();
updateEmptyState();