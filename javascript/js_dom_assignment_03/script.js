document.addEventListener('DOMContentLoaded', () => {
  const composer = document.getElementById('composer');
  const taskInput = document.getElementById('taskInput');
  const taskList = document.getElementById('taskList');
  const taskCount = document.getElementById('taskCount');
  const taskLabel = document.getElementById('taskLabel');
  const emptyState = document.getElementById('emptyState');

  function updateCounter() {
    const incomplete = taskList.querySelectorAll('.task__check:not(:checked)').length;
    taskCount.textContent = incomplete;
    taskLabel.textContent = incomplete === 1 ? 'task left' : 'tasks left';
  }

  function updateEmptyState() {
    const hasTasks = taskList.children.length > 0;
    emptyState.classList.toggle('is-hidden', hasTasks);
  }

  function createTask(text) {
    const li = document.createElement('li');
    li.className = 'task';

    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.className = 'task__check';

    const label = document.createElement('span');
    label.className = 'task__text';
    label.textContent = text;

    const deleteBtn = document.createElement('button');
    deleteBtn.type = 'button';
    deleteBtn.className = 'task__delete';
    deleteBtn.setAttribute('aria-label', `Delete "${text}"`);
    deleteBtn.textContent = '\u00D7';

    function toggleComplete() {
      checkbox.checked = !checkbox.checked;
      li.classList.toggle('task--complete', checkbox.checked);
      updateCounter();
    }

    checkbox.addEventListener('change', () => {
      li.classList.toggle('task--complete', checkbox.checked);
      updateCounter();
    });

    label.addEventListener('click', toggleComplete);

    deleteBtn.addEventListener('click', () => {
      li.remove();
      updateCounter();
      updateEmptyState();
    });

    li.appendChild(checkbox);
    li.appendChild(label);
    li.appendChild(deleteBtn);

    return li;
  }

  function addTask(rawText) {
    const text = rawText.trim();
    if (text === '') return;

    const task = createTask(text);
    taskList.appendChild(task);

    updateCounter();
    updateEmptyState();
  }

  composer.addEventListener('submit', (event) => {
    event.preventDefault();
    addTask(taskInput.value);
    taskInput.value = '';
    taskInput.focus();
  });

  updateCounter();
  updateEmptyState();
});
