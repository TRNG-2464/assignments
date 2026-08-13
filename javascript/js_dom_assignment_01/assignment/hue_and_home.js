const label = document.querySelector('.color-label');

const highlighterBtn = document.querySelector('.btn.highlighter');
highlighterBtn.addEventListener('click', function () {
    const square = document.querySelector('.square');
    square.style.backgroundColor = '#D6FF3D';
    label.textContent = 'Highlighter (#D6FF3D)';
});

const sulfurBtn = document.querySelector('.btn.sulfur');
sulfurBtn.addEventListener('click', function () {
    const square = document.querySelector('.square');
    square.style.backgroundColor = '#FFF04D';
    label.textContent = 'Sulfur (#FFF04D)';
});

const marigoldBtn = document.querySelector('.btn.marigold');
marigoldBtn.addEventListener('click', function () {
    const square = document.querySelector('.square');
    square.style.backgroundColor = '#FFB000';
    label.textContent = 'Marigold (#FFB000)';
});

const persimmonBtn = document.querySelector('.btn.persimmon');
persimmonBtn.addEventListener('click', function () {
    const square = document.querySelector('.square');
    square.style.backgroundColor = '#FF5A1F';
    label.textContent = 'Persimmon (#FF5A1F)';
});

const flamingoBtn = document.querySelector('.btn.flamingo');
flamingoBtn.addEventListener('click', function () {
    const square = document.querySelector('.square');
    square.style.backgroundColor = '#FF4F81';
    label.textContent = 'Flamingo (#FF4F81)';
});
