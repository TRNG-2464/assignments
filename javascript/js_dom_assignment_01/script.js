const swatches = document.querySelectorAll('.swatch');
const preview = document.getElementById('preview');
const valueDisplay = document.getElementById('valueDisplay');

swatches.forEach(swatch => {
    swatch.addEventListener('click', () => {
        swatches.forEach(s => s.classList.remove('selected'));
        swatch.classList.add('selected');

        const color = swatch.dataset.color;
        const name = swatch.dataset.name;

        preview.style.backgroundColor = color;
        valueDisplay.textContent = `${name} — ${color}`;
    });
});
