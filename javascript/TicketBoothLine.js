function countOutofOrder(ticketLine){
    let ticketLineCopy = ticketLine.slice();
    ticketLineCopy.sort((a, b) => a - b);
    let count =0;
    for(let i=0;i<ticketLineCopy.length;i++){
        if(ticketLine[i]!==ticketLineCopy[i]){
            count++;
        }
    }
    return count;
}

console.log(countOutofOrder([3, 1, 2, 5, 4])); // expect 5
console.log(countOutofOrder([1, 2, 3, 4, 5])); // expect 0
console.log(countOutofOrder([]));              // expect 0

let myLine = [3, 1, 2, 5, 4];
countOutofOrder(myLine);
console.log(myLine); // should still print [3, 1, 2, 5, 4], unchanged


function getOutofOrderTickets(ticketLine){
    let ticketLineCopy = ticketLine.slice();
    ticketLineCopy.sort((a, b) => a - b);
    let ticketNums =[];
    for(let i=0;i<ticketLineCopy.length;i++){
        if(ticketLine[i]!==ticketLineCopy[i]){
            ticketNums.push(ticketLine[i]);
        }
    }
    return ticketNums;
}

console.log(getOutofOrderTickets([3, 1, 2, 5, 4]));
// sorted would be [1, 2, 3, 4, 5]
// every position mismatches, so expect [3, 1, 2, 5, 4] (the original values, in original order)

console.log(getOutofOrderTickets([1, 2, 3, 4, 5]));
// expect [] — already correct

console.log(getOutofOrderTickets([]));
// expect []

function minSwapsToOrder(ticketLine) {
    let sorted = ticketLine.slice();
    sorted.sort((a, b) => a - b);
    let visited = new Array(ticketLine.length).fill(false);
    let swaps = 0;

    for (let i = 0; i < ticketLine.length; i++) {
        // if already visited, or already in the correct spot, skip it
        if (visited[i] || ticketLine[i] === sorted[i]) {
            continue;
        }

        // otherwise, trace the cycle starting at position i
        let cycleSize = 0;
        let j = i;

        while (!visited[j]) {
            visited[j] = true;
            // find where the ticket currently at position j *should* go in sorted order
            j = sorted.indexOf(ticketLine[j]);
            cycleSize++;
        }

        if (cycleSize > 0) {
            swaps += (cycleSize - 1);
        }
    }

    return swaps;
}
console.log(minSwapsToOrder([3, 1, 2])); // expect 2
console.log(minSwapsToOrder([1, 2, 3, 4, 5])); // expect 0
console.log(minSwapsToOrder([])); // expect 0

function findLineIssues(ticketLine) {
    let nullLineIssues = [];
    let seen = {};

    // Pass 1: find nulls, and group indices by ticket number
    for (let i = 0; i < ticketLine.length; i++) {
        let ticket = ticketLine[i];

        if (ticket === null) {
            nullLineIssues.push(i);
        } else {
            if (seen[ticket] === undefined) {
                seen[ticket] = [];
            }
            seen[ticket].push(i);
        }
    }

    // Pass 2: pull out only the tickets that appeared more than once
    let duplicates = [];
    for (let key in seen) {
        if (seen[key].length > 1) {
            duplicates.push(seen[key]);
        }
    }

    return {
        nulls: nullLineIssues,
        duplicates: duplicates
    };
}

console.log(findLineIssues([1, null, 3, null, 5]));
// expect [1, 3] (the indices where null appears)

console.log(findLineIssues([5, 2, 5, null, 3, 2, null]));
// expect: { nulls: [3, 6], duplicates: [ [0, 2], [1, 5] ] }