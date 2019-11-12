function multiplesCount(num, b){
  console.log(num.filter(x=>x%b==0).length);
    
}
multiplesCount([1, 2, 3, 4, 5, 6, 7, 8, 9], 3);