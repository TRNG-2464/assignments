const MAX_LENGTH = 280;
const WARNING_WITHIN = 20;

const caption = document.getElementById("caption");
const counter = document.getElementById("counter");
const clearButton = document.getElementById("clear");

function updateCounter() {
    const count = caption.value.length;

    // live count
    counter.textContent = count + " / " + MAX_LENGTH;

    // Remove previous visual states, and then adding "warning" or "over-limit" when needed.
    // Warning: count is within WARNING_WITHIN of MAX_LENGTH (e.g. 260–280)
    // Over limit: count is greater than MAX_LENGTH
    counter.classList.remove("warning", "over-limit");
    if (count > MAX_LENGTH) {
        counter.classList.add("over-limit");
    } else if (count >= MAX_LENGTH - WARNING_WITHIN) {
        counter.classList.add("warning");
    }
}

caption.addEventListener("input", () => {
    updateCounter();
});

clearButton.addEventListener("click", () => {
    // Empty the textarea, then reuse updateCounter so the display resets to normal.
    caption.textContent = "";
    updateCounter();
});

updateCounter();
