function Car(){
    this.color = "Default";
    this.make = "Default";
    this.model = "Default";
}
var RedHondaAccord = new Car();
RedHondaAccord.color = "Red";
RedHondaAccord.make = "Honda";
RedHondaAccord.model = "Accord";
Car.prototype.drive = function (speed){
    console.log(this.color + "  "+ this.make + " " + this.model + 
        " is driving at " + speed + " mph");
}
Car.prototype.stop = function(){
    console.log("The " + this.color + "  "+ this.make + " " + this.model + 
        " is stopping." );
}
RedHondaAccord.drive(300);