'use strict';

const MAX_CHARACTERS = 280;
const WARNING_THRESHOLD = 20;

const caption = document.querySelector('#caption');
const counter = document.querySelector('#character-counter');
const clearCaptionButton = document.querySelector('#clear-caption');
const hardLimitCheckbox = document.querySelector('#hard-limit');

function updateCounter() {
  if (hardLimitCheckbox.checked && caption.value.length > MAX_CHARACTERS) {
    caption.value = caption.value.slice(0, MAX_CHARACTERS);
  }

  const characterCount = caption.value.length;
  counter.textContent = `${characterCount} / ${MAX_CHARACTERS}`;

  const isOverLimit = characterCount > MAX_CHARACTERS;
  const isNearLimit = characterCount >= MAX_CHARACTERS - WARNING_THRESHOLD;

  counter.classList.toggle('is-normal', !isNearLimit && !isOverLimit);
  counter.classList.toggle('is-warning', isNearLimit && !isOverLimit);
  counter.classList.toggle('is-over-limit', isOverLimit);
}

caption.addEventListener('input', updateCounter);

clearCaptionButton.addEventListener('click', () => {
  caption.value = '';
  updateCounter();
  caption.focus();
});

hardLimitCheckbox.addEventListener('change', updateCounter);

updateCounter();
