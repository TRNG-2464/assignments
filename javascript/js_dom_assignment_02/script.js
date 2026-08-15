const maxCharacters = 280;
const warningDistance = 20;

const captionInput = document.getElementById("caption");
const counter = document.getElementById("counter");
const clearButton = document.getElementById("clear-button");

function updateCounter() {
  const characterCount = captionInput.value.length;

  counter.textContent = `${characterCount} / ${maxCharacters}`;

  // Reset the counter's visual state.
  counter.classList.remove("warning", "over-limit");

  if (characterCount > maxCharacters) {
    counter.classList.add("over-limit");
  } else if (characterCount >= maxCharacters - warningDistance) {
    counter.classList.add("warning");
  }
}

captionInput.addEventListener("input", updateCounter);

clearButton.addEventListener("click", () => {
  captionInput.value = "";
  updateCounter();
  captionInput.focus();
});