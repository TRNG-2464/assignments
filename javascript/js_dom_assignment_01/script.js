const swatchButtons = document.querySelectorAll(".swatch");
const colorPreview = document.getElementById("color-preview");
const colorValue = document.getElementById("color-value");
const previewHeading = document.getElementById("preview-heading");

swatchButtons.forEach((button) => {
  button.addEventListener("click", () => {
    const selectedColor = button.dataset.color;
    const selectedName = button.dataset.name;

    // Update the preview area.
    colorPreview.style.backgroundColor = selectedColor;

    // Update the displayed color name and value.
    colorValue.textContent = selectedColor;
    previewHeading.textContent = selectedName;

    // Update the preview's accessibility label.
    colorPreview.setAttribute(
      "aria-label",
      `${selectedName} color preview`
    );

    // Remove the selected state from every swatch.
    swatchButtons.forEach((swatch) => {
      swatch.classList.remove("selected");
      swatch.setAttribute("aria-pressed", "false");
    });

    // Add the selected state to the clicked swatch.
    button.classList.add("selected");
    button.setAttribute("aria-pressed", "true");
  });
});