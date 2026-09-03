'use strict';

const preview = document.querySelector('#color-preview');
const colorValue = document.querySelector('#color-value');
const swatches = [...document.querySelectorAll('.swatch')];
const randomColorButton = document.querySelector('#random-color');
const customColorInput = document.querySelector('#custom-color');

function getReadableTextColor(hexColor) {
  const red = Number.parseInt(hexColor.slice(1, 3), 16);
  const green = Number.parseInt(hexColor.slice(3, 5), 16);
  const blue = Number.parseInt(hexColor.slice(5, 7), 16);
  const luminance = (red * 0.299 + green * 0.587 + blue * 0.114) / 255;

  return luminance > 0.6 ? '#1d2930' : '#ffffff';
}

function applyColor(color, name, selectedSwatch = null) {
  const normalizedColor = color.toUpperCase();

  preview.style.backgroundColor = normalizedColor;
  preview.style.color = getReadableTextColor(normalizedColor);
  colorValue.textContent = name ? `${name} · ${normalizedColor}` : normalizedColor;

  for (const swatch of swatches) {
    const isSelected = swatch === selectedSwatch;
    swatch.classList.toggle('is-selected', isSelected);
    swatch.setAttribute('aria-pressed', String(isSelected));
  }
}

for (const swatch of swatches) {
  swatch.addEventListener('click', () => {
    applyColor(swatch.dataset.color, swatch.dataset.name, swatch);
  });
}

randomColorButton.addEventListener('click', () => {
  const randomIndex = Math.floor(Math.random() * swatches.length);
  swatches[randomIndex].click();
});

customColorInput.addEventListener('input', () => {
  applyColor(customColorInput.value, 'Custom color');
});
