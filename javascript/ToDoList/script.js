let taskInput = document.getElementById('taskInput');
let addBtn = document.getElementById('addBtn');
let taskList = document.getElementById("taskList")
let clearCompletedBtn = document.getElementById('clearCompletedBtn')
let filterAllBtn = document.getElementById('filterAll');
let filterActiveBtn = document.getElementById('filterActive');
let filterCompletedBtn = document.getElementById('filterCompleted');

addBtn.addEventListener('click', function (){
    let taskText = taskInput.value.trim();

    if(taskText===""){
        return;
    }
    //sheet of paper
    let newTask = document.createElement('li');
    let checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    let taskSpan = document.createElement('span');
    taskSpan.textContent = taskText;
    let deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';

    newTask.appendChild(checkbox);
    newTask.appendChild(taskSpan);
    newTask.appendChild(deleteBtn);

    taskList.appendChild(newTask);

    //clear the input box after
    taskInput.value="";
    updateCounter();
    deleteBtn.addEventListener('click',function (){
        newTask.remove();
        updateCounter();
    });
    checkbox.addEventListener('change',function () {
        if(checkbox.checked){
            taskSpan.classList.add('completed');
        }else{
            taskSpan.classList.remove('completed')
        }
        updateCounter();
    });
});

taskInput.addEventListener('keydown',function (event){
   if(event.key === "Enter"){
       addBtn.click()
   }
});

function updateCounter(){
    let allCheckboxes = document.querySelectorAll('#taskList input[type="checkbox"]');
    let incompleteCount =0;

    for(let i=0;i<allCheckboxes.length;i++){
        if(!allCheckboxes[i].checked){
            incompleteCount++
        }
    }
    let counter = document.getElementById('counter');
    counter.textContent = incompleteCount + " tasks left";
}

clearCompletedBtn.addEventListener('click',function () {
    let allTasks = document.querySelectorAll('#taskList li');

    for (let i = 0; i < allTasks.length; i++) {
        let task = allTasks[i];
        let taskCheckbox = task.querySelector('input[type="checkbox"]');
        if (taskCheckbox.checked) {
            task.remove();
        }
    }
    updateCounter()
});

function applyFilter(filterType) {
    let allTasks = document.querySelectorAll('#taskList li');

    for (let i = 0; i < allTasks.length; i++) {
        let task = allTasks[i];
        let taskCheckbox = task.querySelector('input[type="checkbox"]');

        if (filterType === 'all') {
            task.classList.remove('hidden');
        } else if (filterType === 'active') {
            if (taskCheckbox.checked) {
                task.classList.add('hidden');
            } else {
                task.classList.remove('hidden');
            }
        } else if (filterType === 'completed') {
            if (taskCheckbox.checked) {
                task.classList.remove('hidden');
            } else {
                task.classList.add('hidden');
            }
        }
    }
}

filterAllBtn.addEventListener('click', function () {
    applyFilter('all');
});

filterActiveBtn.addEventListener('click', function () {
    applyFilter('active');
});

filterCompletedBtn.addEventListener('click', function () {
    applyFilter('completed');
});