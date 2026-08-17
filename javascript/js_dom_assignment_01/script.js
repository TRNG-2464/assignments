const swatches = document.querySelectorAll(".swatch");
const preview = document.getElementById("preview");


swatches.forEach((swatch) => {
    swatch.addEventListener("click", () => {
        const color = swatch.value;

        // Remove "selected" from every swatch, then add it to the one that was clicked.
        swatches.forEach((button) => {
            button.classList.remove("selected"); // classList adds or removes a class without touching the rest of the element
        });
        swatch.classList.add("selected");

        // Update the preview area background to this color.
        preview.style.backgroundColor = color;

        // Update the color value text (hex) so the customer can note it down.
        preview.style.color = color;
    });
});
