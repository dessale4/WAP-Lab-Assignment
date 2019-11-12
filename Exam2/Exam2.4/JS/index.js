function calculateAverage(a,b){
    let argumentLength = arguments.length;
    let sum = 0;
    for(let i = 0; i<argumentLength; i++){
        sum +=arguments[i];
    }
    return (sum/argumentLength);
}
console.log(calculateAverage(2,3,5));