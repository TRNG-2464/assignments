'use strict';

const taskForm = document.querySelector('#task-form');
const taskInput = document.querySelector('#task-input');
const taskList = document.querySelector('#task-list');
const taskCounter = document.querySelector('#task-counter');
const clearCompletedButton = document.querySelector('#clear-completed');
const filterButtons = [...document.querySelectorAll('.filter-button')];
const emptyState = document.querySelector('#empty-state');

let activeFilter = 'all';
let nextTaskId = 1;

function getTasks() {
  return [...taskList.querySelectorAll('.task')];
}

function updateTaskCounter() {
  const incompleteCount = getTasks().filter((task) => !task.classList.contains('is-completed')).length;
  taskCounter.textContent = `${incompleteCount} task${incompleteCount === 1 ? '' : 's'} left`;
}

function updateEmptyState() {
  const hasVisibleTask = getTasks().some((task) => !task.classList.contains('is-hidden'));
  emptyState.classList.toggle('is-hidden', hasVisibleTask);
}

function applyFilter() {
  for (const task of getTasks()) {
    const isCompleted = task.classList.contains('is-completed');
    const shouldShow = activeFilter === 'all'
      || (activeFilter === 'active' && !isCompleted)
      || (activeFilter === 'completed' && isCompleted);

    task.classList.toggle('is-hidden', !shouldShow);
  }

  updateEmptyState();
}

function createTask(taskText) {
  const taskId = `task-${nextTaskId}`;
  nextTaskId += 1;

  const task = document.createElement('li');
  task.className = 'task';

  const checkbox = document.createElement('input');
  checkbox.className = 'task-checkbox';
  checkbox.id = taskId;
  checkbox.type = 'checkbox';
  checkbox.setAttribute('aria-label', `Mark ${taskText} as complete`);

  const label = document.createElement('label');
  label.className = 'task-label';
  label.htmlFor = taskId;
  label.textContent = taskText;

  const deleteButton = document.createElement('button');
  deleteButton.className = 'delete-button';
  deleteButton.type = 'button';
  deleteButton.textContent = 'Delete';
  deleteButton.setAttribute('aria-label', `Delete ${taskText}`);

  checkbox.addEventListener('change', () => {
    task.classList.toggle('is-completed', checkbox.checked);
    updateTaskCounter();
    applyFilter();
  });

  deleteButton.addEventListener('click', () => {
    task.remove();
    updateTaskCounter();
    applyFilter();
  });

  task.appendChild(checkbox);
  task.appendChild(label);
  task.appendChild(deleteButton);
  return task;
}

taskForm.addEventListener('submit', (event) => {
  event.preventDefault();

  const taskText = taskInput.value.trim();
  if (!taskText) {
    return;
  }

  taskList.appendChild(createTask(taskText));
  taskInput.value = '';
  taskInput.focus();
  updateTaskCounter();
  applyFilter();
});

clearCompletedButton.addEventListener('click', () => {
  for (const task of getTasks()) {
    if (task.classList.contains('is-completed')) {
      task.remove();
    }
  }

  updateTaskCounter();
  applyFilter();
});

for (const button of filterButtons) {
  button.addEventListener('click', () => {
    activeFilter = button.dataset.filter;

    for (const filterButton of filterButtons) {
      const isActive = filterButton === button;
      filterButton.classList.toggle('is-active', isActive);
      filterButton.setAttribute('aria-pressed', String(isActive));
    }

    applyFilter();
  });
}

updateTaskCounter();
applyFilter();
