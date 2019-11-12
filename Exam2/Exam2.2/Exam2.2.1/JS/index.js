const car = {
    make: "default",
    model:"default",
    color:"default",
    drive: function(speed){
        console.log(this.color + "  "+ this.make + " " + this.model + 
        " is driving at " + speed + " mph");
    },
    stop: function(){
        console.log("The " + this.color + "  "+ this.make + " " + this.model + 
        " is stopping." );
    }
}
const RedHondaAccord = Object.create(car);
RedHondaAccord.color = "Red";
RedHondaAccord.make = "Honda";
RedHondaAccord.model = "Accord";
RedHondaAccord.drive(200);