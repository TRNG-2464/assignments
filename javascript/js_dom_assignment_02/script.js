const captionBox = document.getElementById('caption-box');
const captionCount = document.getElementById('caption-count');
const maxLength = 100;
const warnLength = maxLength - 20;

function updateCaption(currentLength) {
    captionCount.textContent = 'current:' + currentLength + ' / max:' + maxLength;

    if (currentLength > maxLength) {
        captionBox.style.color = 'red'
    } else if (currentLength > warnLength) {
        captionBox.style.color = 'yellow';
    } else {
        captionBox.style.color = 'black';
    }
}

function captionOnKey(event) {
    updateCaption(captionBox.value.length);
}

captionBox.addEventListener('keydown', captionOnKey);
captionBox.addEventListener('keyup', captionOnKey);

const resetButton = document.getElementById('reset-button');
resetButton.addEventListener('click', (event) => {
    captionBox.value = '';
    updateCaption(0);
});
