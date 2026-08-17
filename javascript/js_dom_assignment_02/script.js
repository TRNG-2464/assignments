let maxLength = 100;
let caption = document.querySelector("#caption");
let counter = document.querySelector("#counter");
let clear = document.querySelector("#clear");

caption.addEventListener("input", function(event) {
    let currentLength = event.target.value.length;
    counter.textContent = `${currentLength} / ${maxLength}`;

    counter.classList.remove("normal", "warning", "over-limit");

    if (currentLength > maxLength) {
        counter.classList.add("over-limit");
    } else if (currentLength >= maxLength - 20) {
        counter.classList.add("warning");
    } else {
        counter.classList.add("normal");
    }
});

clear.addEventListener("click", function() {
    caption.value = "";
    caption.dispatchEvent(new Event("input"));
});