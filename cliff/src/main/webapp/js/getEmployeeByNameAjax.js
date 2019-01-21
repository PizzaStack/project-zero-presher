function GetEmployeeByName(){
	var employee = $('#fname').val();
//	let employee = document.getElementById("employeeNames");
//	let selectedEmployee = employee.options[employee.selectedIndex].value;
		
	var getEmployeeByName = new XMLHttpRequest();

	getEmployeeByName.open('POST', 'GetEmployeeByName', true);
	updateFname.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	getEmployeeByName.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			let employee = JSON.parse(this.responseText);
			console.log(employee);
			document.getElemenyById("ajaxText").innerHTML = employee;
		}
	};
	getEmployeeByName.send(`employee=${employee}`);
}
//var GetEmployeeByName = () => 