
// Select all color swatch buttons
const swatches = document.querySelectorAll(".swatch");

// Select the preview area
const preview = document.getElementById("preview");

// Select the element that displays the color value
const colorValue = document.getElementById("colorValue");

// Add a click event listener to every swatch
swatches.forEach(function (swatch) {

    swatch.addEventListener("click", function () {

        // Get the color stored in the data-color attribute
        const selectedColor = swatch.dataset.color;

        // Update the preview background color
        preview.style.backgroundColor = selectedColor;

        // Update the displayed color value
        colorValue.textContent = selectedColor;

        // Remove "selected" from all swatches
        swatches.forEach(function (item) {
            item.classList.remove("selected");
        });

        // Add "selected" to the clicked swatch
        swatch.classList.add("selected");
    });
});