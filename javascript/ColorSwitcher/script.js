//like a list for buttons that are in the html file
let buttons = document.querySelectorAll('button[data-color]');

//iterate through each button in the list and set its color from CSS
for(let i=0;i<buttons.length;i++){
    let button = buttons[i];
    let color = button.dataset.color;
    button.style.backgroundColor = color;
    //anonymous function - what to do when a click happens.
    button.addEventListener('click', function (){
        let preview = document.getElementById('preview');
        let colorValueText = document.getElementById('colorValue');
        preview.style.backgroundColor = color;
        colorValueText.textContent = color;

        for(let j =0; j<buttons.length;j++){
            buttons[j].classList.remove('selected');
        }

        button.classList.add('selected');
    });
}

let randomBtn = document.getElementById('randomColorBtn');
randomBtn.addEventListener('click',function (){
   let randomIndex = Math.floor(Math.random()*buttons.length);
   let randomButton = buttons[randomIndex];
   randomButton.click();
});

let input = document.getElementById('customColor');
input.addEventListener('input',function (){
    let chosenColor = input.value;
    let preview = document.getElementById('preview');
    let colorValueText = document.getElementById('colorValue');
    preview.style.backgroundColor = chosenColor;
    colorValueText.textContent = chosenColor;
});