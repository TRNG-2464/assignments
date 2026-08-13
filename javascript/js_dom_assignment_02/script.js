document.addEventListener('DOMContentLoaded', () => {
  // Adjust this to change the caption limit.
  const MAX_CHARS = 280;
  const WARNING_THRESHOLD = 20; // switch to warning when this many chars remain

  const textarea = document.getElementById('caption');
  const charCount = document.getElementById('charCount');
  const charMax = document.getElementById('charMax');
  const clearBtn = document.getElementById('clearBtn');
  const dial = document.getElementById('dial');
  const dialProgress = document.getElementById('dialProgress');

  const RADIUS = 28;
  const CIRCUMFERENCE = 2 * Math.PI * RADIUS;

  dialProgress.style.strokeDasharray = `${CIRCUMFERENCE}`;
  charMax.textContent = MAX_CHARS;

  function updateCounter() {
    const length = textarea.value.length;
    charCount.textContent = length;

    // Fill the dial proportionally, capping the visual ring at 100%
    // even if the user types past the limit.
    const fraction = Math.min(length / MAX_CHARS, 1);
    const offset = CIRCUMFERENCE * (1 - fraction);
    dialProgress.style.strokeDashoffset = `${offset}`;

    dial.classList.remove('is-warning', 'is-over');

    if (length > MAX_CHARS) {
      dial.classList.add('is-over');
    } else if (length >= MAX_CHARS - WARNING_THRESHOLD) {
      dial.classList.add('is-warning');
    }
  }

  function clearCaption() {
    textarea.value = '';
    updateCounter();
    textarea.focus();
  }

  textarea.addEventListener('input', updateCounter);
  clearBtn.addEventListener('click', clearCaption);

  updateCounter();
});
