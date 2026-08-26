
// Maximum number of characters allowed
const MAX_CHARACTERS = 280;

// Number of characters before the limit where warning begins
const WARNING_LIMIT = 20;

// Select elements from the HTML
const caption = document.getElementById("caption");
const counter = document.getElementById("counter");
const clearButton = document.getElementById("clearButton");

// Function to update the character counter
function updateCounter() {

    // Get the current number of characters
    const currentCharacters = caption.value.length;

    // Update the counter text
    counter.textContent = `${currentCharacters} / ${MAX_CHARACTERS}`;

    // Remove previous visual states
    counter.classList.remove("warning");
    counter.classList.remove("over-limit");

    // Check if the user is over the character limit
    if (currentCharacters > MAX_CHARACTERS) {

        counter.classList.add("over-limit");

    }
    // Check if the user is approaching the character limit
    else if (currentCharacters >= MAX_CHARACTERS - WARNING_LIMIT) {

        counter.classList.add("warning");
    }
}

// Update counter whenever the user types
caption.addEventListener("input", updateCounter);

// Clear the textarea and reset the counter
clearButton.addEventListener("click", function () {

    // Empty the textarea
    caption.value = "";

    // Reset the counter
    updateCounter();

    // Put the cursor back inside the textarea
    caption.focus();
});