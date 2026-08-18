class ColorSwatch {
    constructor(name, hexColor) {
        this.name = name;
        this.hexColor = hexColor;
    }
}

const colors = [
    new ColorSwatch("Mightnight Blue", "#2a2aae"),
    new ColorSwatch("Coral", "#FF7F50"),
    new ColorSwatch("Teal", "#19caca"),
    new ColorSwatch("Lavender", "#ba60ea"),
    new ColorSwatch("Crimson", "#900e28"),
];

// Get button-container
const buttonContainer = document.querySelector(".button-container");
const previewContainer = document.querySelector(".preview-container");
const previewTextEle = document.querySelector(".preview-container p");

// Add button colors
colors.forEach((color, index) => {
    const button = document.createElement("button");
    button.style.background = color.hexColor;
    button.textContent = color.name;
    button.addEventListener("click", (e) => {
        didClickColorSwatch(index);
    });
    buttonContainer.appendChild(button);
});

let selectedColorIndex = 0;

didClickColorSwatch(selectedColorIndex);

function didClickColorSwatch(selectedColorIndex) {
    const selectedSwatch = colors[selectedColorIndex];
    updateButtonContainer(selectedColorIndex);
    updatePreview(selectedSwatch);
}

function updatePreview(selectedSwatch) {
    previewContainer.style.background = selectedSwatch.hexColor;
    previewTextEle.textContent = selectedSwatch.hexColor;
}

function updateButtonContainer(selectedColorIndex) {
    for (let i = 0; i < buttonContainer.children.length; i++) {
        const button = buttonContainer.children[i];

        if (i === selectedColorIndex) {
            button.classList.add("selectedColor");
        } else {
            button.classList.remove("selectedColor");
        }
    }
}
