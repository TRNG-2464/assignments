document.addEventListener('DOMContentLoaded', () => {
  const chips = document.querySelectorAll('.chip');
  const previewSwatch = document.getElementById('previewSwatch');
  const previewName = document.getElementById('previewName');
  const previewValue = document.getElementById('previewValue');

  function selectChip(chip) {
    // Clear the indicator from every chip, then mark only this one.
    chips.forEach((c) => c.classList.remove('is-selected'));
    chip.classList.add('is-selected');

    const name = chip.dataset.name;
    const value = chip.dataset.value;

    previewSwatch.style.backgroundColor = value;
    previewName.textContent = name;
    previewValue.textContent = value.toUpperCase();
  }

  chips.forEach((chip) => {
    chip.addEventListener('click', () => selectChip(chip));
  });
});
