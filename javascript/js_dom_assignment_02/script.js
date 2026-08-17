const MAX_LENGTH = 280;
const WARNING_THRESHOLD = 20;

const caption = document.getElementById('caption');
const counter = document.getElementById('counter');
const clearBtn = document.getElementById('clearBtn');

function updateCounter() {
    const length = caption.value.length;
    counter.textContent = `${length} / ${MAX_LENGTH}`;

    counter.classList.remove('warning', 'over');

    if (length > MAX_LENGTH) {
        counter.classList.add('over');
    } else if (length >= MAX_LENGTH - WARNING_THRESHOLD) {
        counter.classList.add('warning');
    }
}

caption.addEventListener('input', updateCounter);

clearBtn.addEventListener('click', () => {
    caption.value = '';
    updateCounter();
});
