function countOutOfOrder(arr) {
    let count = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] != i+1) {
            count += 1;
        }
    }
    return count;
}
//console.log(countOutOfOrder([1, 2, 3, 4, 5])); //0
//console.log(countOutOfOrder([5, 4, 3, 2, 1])); //4
//console.log(countOutOfOrder([1, 6, 6, 6, 6])); //4
//console.log(countOutOfOrder([0])); //1

function getOutOfOrderTickets(arr) {
    let ret = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] != i+1) {
            ret.push(i);
        }
    }
    return ret;
}
console.log(getOutOfOrderTickets([1, 2, 3, 4, 5])); //0
console.log(getOutOfOrderTickets([5, 4, 3, 2, 1])); //4
console.log(getOutOfOrderTickets([1, 6, 6, 6, 6])); //4
console.log(getOutOfOrderTickets([0])); //1

function minSwapsToOrder(arr) {
    let count = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] != i+1) {
            count += 1;
        }
    }
    return count;
}