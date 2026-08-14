const colorPreview = document.getElementById('color-preview');
const colorPreviewText = document.getElementById('color-preview-text');
const buttons = document.getElementsByTagName('button');

function buttonSwatchOnClick(event) {
    for (let button of buttons) {
        button.classList.remove('highlight-btn');
    }

    let button = event.target;
    colorPreview.style.backgroundColor = button.style.backgroundColor;
    button.classList.add('highlight-btn');

    console.log(button.style.backgroundColor);
    colorPreviewText.textContent = button.getAttribute('data-hex');
}

for (button of buttons) {
    button.addEventListener('click', buttonSwatchOnClick);
}
