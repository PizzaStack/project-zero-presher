
var requestEmployee = new XMLHttpRequest();

requestEmployee.open('GET', 'employee/employee.html');

requestEmployee.onreadystatechange = function(){
    if(requestEmployee.readyState == 4){
         document.getElementById('ajaxText').innerHTML = requestEmployee.responseText;
        
    }
};

// function getEmployeePage(){
//     requestEmployee.send();    
// }

var getEmployeePage = () => requestEmployee.send()