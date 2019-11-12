const Employee = (function(){
    let name = "default";
    let age = "default";
    let salary = "default";
    function getAge(){
        return age;
    }
    function getSalary(){
        return salary;
    }
    function getName(){
        return name;
    }
    return {
        setAge : function(newAge){
            age = newAge;
        },
        setSalary : function(newSalary){
            salary = newSalary;
        },
        setName: function(newName){
            name = newName;
        },
        increaseSalary: function (percentage){
            salary += getSalary()* 0.01 * percentage ;
        },
        incrementAge: function(){
            age++;
        },
        getEmployeeInfo: function(){
            return `\nname: ${getName()}\nage: ${getAge()}\nsalary: ${getSalary()}`
        }
    }
})();
//Add new Employee
Employee.setName("John Smith");
Employee.setAge(25);
Employee.setSalary(110000);
console.log(`Employee Information is:\n${Employee.getEmployeeInfo()}`);

// Update Employee information
Employee.increaseSalary(20);
Employee.incrementAge();
console.log(`\nUpdate Employee Information is:\n${Employee.getEmployeeInfo()}`)