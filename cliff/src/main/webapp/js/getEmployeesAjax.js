(function(){
var getAllEmployees = new XMLHttpRequest();

getAllEmployees.open('POST', 'GetAllEmployees', true);

getAllEmployees.onreadystatechange = function() {

	if (this.readyState === 4 && this.status === 200) {
		let employees = JSON.parse(this.responseText);

		for (i in employees) {
			json = employees[i];
			let select = document.createElement("option");
			let name = document.createTextNode(json.First_Name);
			select.appendChild(name);
			// select.addEventListener("click", alert);
			document.getElementById("employeesNames").appendChild(select);

		}
	}
};
getAllEmployees.send();
})()

function GetEmployeeByName() {
	var employee = $('#employee').val();
//	let employeeDropList = document.getElementById("employeesNames");
//	let allEmployeeOptions = employeeDropList.options;
//	let selectedEmployee = allEmployeeOptions[employeeDropList.selectedIndex];
	
	var getEmployeeByName = new XMLHttpRequest();	
	getEmployeeByName.open('POST', 'GetEmployeeByNameServlet', true);
	updateFname.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	getEmployeeByName.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			let json = JSON.parse(this.responseText);
			console.log(json);
			document.getElementById("ajaxText").innerHTML = json.First_Name;
		}

	}

	getEmployeeByName.send(`employee=${employee}`);
}


