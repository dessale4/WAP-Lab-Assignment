function make_adder(inc){
    let counter = 0;
    return function(){
        counter +=inc;
        console.log(counter);
    }
}
var add5 = make_adder(5);
add5();
add5();
add5();