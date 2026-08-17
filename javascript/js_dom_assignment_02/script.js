// Character Counter
// Updates a live counter as the user types, with warning/over-limit states.

const MAX_CHARACTERS = 280;
const WARNING_THRESHOLD = 20; // Warning style within this many chars of the max

const captionInput = document.getElementById('captionInput');
const charCounter = document.getElementById('charCounter');
const clearBtn = document.getElementById('clearBtn');

// Updates the counter text and visual state based on caption length
function updateCounter() {
  const length = captionInput.value.length;
  charCounter.textContent = `${length} / ${MAX_CHARACTERS}`;

  charCounter.classList.remove('normal', 'warning', 'over-limit');

  if (length > MAX_CHARACTERS) {
    charCounter.classList.add('over-limit');
  } else if (length >= MAX_CHARACTERS - WARNING_THRESHOLD) {
    charCounter.classList.add('warning');
  } else {
    charCounter.classList.add('normal');
  }
}

captionInput.addEventListener('input', () => {
  updateCounter();
});

clearBtn.addEventListener('click', () => {
  captionInput.value = '';
  updateCounter();
});

updateCounter();
