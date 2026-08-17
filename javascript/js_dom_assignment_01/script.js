// ---------------------------------------------
// Element references
// ---------------------------------------------
const swatches = document.querySelectorAll('.swatch');
const previewArea = document.getElementById('previewArea');
const previewPlaceholder = document.getElementById('previewPlaceholder');
const valueText = document.getElementById('valueText');

// ---------------------------------------------
// Core update logic — shared by every swatch click
// ---------------------------------------------
function selectSwatch(swatchButton) {
  const color = swatchButton.dataset.color;
  const name = swatchButton.dataset.name;

  // Update the preview area
  previewArea.style.backgroundColor = color;

  // Hide the placeholder text once a color has been chosen
  if (previewPlaceholder) {
    previewPlaceholder.style.display = 'none';
  }

  // Update the value text (name + hex code)
  valueText.textContent = `${name} — ${color}`;

  // Clear the "selected" indicator from every swatch,
  // then apply it only to the one that was just clicked
  swatches.forEach((swatch) => swatch.classList.remove('is-selected'));
  swatchButton.classList.add('is-selected');
}

// ---------------------------------------------
// Wire up each swatch button
// ---------------------------------------------
swatches.forEach((swatch) => {
  swatch.addEventListener('click', () => selectSwatch(swatch));
});