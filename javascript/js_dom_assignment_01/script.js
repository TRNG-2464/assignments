let preview = document.querySelector("#preview");
let colorValueText = document.querySelector("#color-value");
let buttons = document.querySelectorAll(".button");

buttons.forEach(function(button) {
    button.addEventListener("click", function(event) {
        let computedStyle = window.getComputedStyle(button);
        let backColor = computedStyle.backgroundColor;
        preview.style.backgroundColor = backColor;
        colorValueText.textContent = backColor;
        buttons.forEach(function(btn) {
            btn.classList.remove("selected");
        });
        button.classList.add("selected");
    });
});