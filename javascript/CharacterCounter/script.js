let caption = document.getElementById("caption");
let counter = document.getElementById("counter");
let clearBtn = document.getElementById("clearBtn");
let hardLimitToggle = document.getElementById('hardLimitToggle');
let maxLength = 280;


caption.addEventListener("input",function () {
    if(hardLimitToggle.checked && caption.value.length>maxLength){
        caption.value = caption.value.slice(0, maxLength);
    }
    let currentLength = caption.value.length;
    counter.textContent = currentLength + " / " + maxLength;
    if(currentLength>maxLength){
        counter.classList.add('over-limit');
        counter.classList.remove('warning');
    }else if(currentLength>=(maxLength-20)){
        counter.classList.add('warning');
        counter.classList.remove('over-limit');
    }else{
        counter.classList.remove('warning');
        counter.classList.remove('over-limit')
    }
});

clearBtn.addEventListener('click',function () {
    caption.value="";
    caption.dispatchEvent(new Event('input'));
});

