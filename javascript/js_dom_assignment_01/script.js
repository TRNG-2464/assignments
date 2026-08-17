// Color Switcher
// Handles swatch clicks, updates the preview area and selected state.

const swatchButtons = document.querySelectorAll('.swatch');
const preview = document.getElementById('preview');
const colorValue = document.getElementById('colorValue');

// Updates the preview area's color and value text
function applyColor(color) {
  preview.style.backgroundColor = color;
  colorValue.textContent = color;
}

// Highlights the selected swatch, clears the rest
function setSelectedSwatch(selectedButton) {
  swatchButtons.forEach((button) => {
    button.classList.toggle('selected', button === selectedButton);
  });
}

swatchButtons.forEach((button) => {
  button.addEventListener('click', () => {
    const color = button.dataset.color;
    applyColor(color);
    setSelectedSwatch(button);
  });
});
