$(document).ready(function(){
    setInterval(() => {
        let currentDate = new Date();
        $("#timer").html(currentDate);
    }, 1000);
    
   const studentArray=[];
   const addStudent=function(student){
       addToList(student);
       addToArray(student);
   }
    function addToList(student){
        let newListItem="<li class=\"list-group-item\">" + student.studentId + "-" + student.firstName + "</li>";
        $("#studentList").append(newListItem);
    }
    function addToArray(student){
        studentArray.push(student);
    }
    $.ajax({
        url:"Data/index.json",
        type:"GET",
        datatype:"json"
    }).done(function(studentData){
        studentData.forEach(student => {
            addStudent(student)
        });
    }).fail(function(xhr, status, err) {
        alert("Error: " + status + " - " + err);
    }).always(function(xhr, status) {
        //alert( "The request is complete!" );
    });   
   
    $("#formRegisterStudent").on("submit",function(e) {
        e.preventDefault();
        let studentId = formRegisterStudent.inputStudentID.value;
        let firstName = formRegisterStudent.inputFirstName.value;
        let objNewStudent={
             "studentId": studentId, 
             "firstName": firstName
        }
        addStudent(objNewStudent);
       formRegisterStudent.reset();
       
       $("#studentId").focus();
    });
    $("#studentId").focus();
});


