const MAX_CHARS = 280;
const WARNING_THRESHOLD = 20; // switches to "warning" this many chars before MAX_CHARS

const captionInput = document.getElementById('caption');
const counter = document.getElementById('counter');
const counterText = document.getElementById('counterText');
const ringProgress = document.getElementById('ringProgress');
const composerCard = document.getElementById('composerCard');
const clearBtn = document.getElementById('clearBtn');

// Matches the ring's radius (r="15.5") set in the index.html
const RING_CIRCUMFERENCE = 2 * Math.PI * 15.5;

function updateCounter() {
  const length = captionInput.value.length;

  // Update the counter
  counterText.textContent = `${length} / ${MAX_CHARS}`;

  // Update the ring fill, capped at 100% so it doesn't overflow visually
  const percentFilled = Math.min(length / MAX_CHARS, 1);
  ringProgress.style.strokeDashoffset = RING_CIRCUMFERENCE * (1 - percentFilled);

  // Figure out which state we're in
  let state = 'state-normal';
  if (length > MAX_CHARS) {
    state = 'state-danger';
  } else if (length >= MAX_CHARS - WARNING_THRESHOLD) {
    state = 'state-warning';
  }

  // Clear any previous state classes, then apply the current one
  counter.classList.remove('state-normal', 'state-warning', 'state-danger');
  composerCard.classList.remove('state-normal', 'state-warning', 'state-danger');

  counter.classList.add(state);
  composerCard.classList.add(state);
}

function clearCaption() {
  captionInput.value = '';
  updateCounter();
  captionInput.focus();
}

captionInput.addEventListener('input', updateCounter);
clearBtn.addEventListener('click', clearCaption);

// Initialize counter/ring on page load
updateCounter();