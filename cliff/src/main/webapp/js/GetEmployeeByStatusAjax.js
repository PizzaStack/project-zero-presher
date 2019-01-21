function getEmployeeByStatus() {
	var x = $('#status').val();
	var trHTML = '';
	// var x = document.getElementById().selectedIndex;
	// var allEmployeeOptions = x.options;
	// var selectedStatus = allEmployeeOptions[x.selectedIndex];
	var employeeByStatus = new XMLHttpRequest();

	employeeByStatus.open('POST', 'GetStatus', true);
	employeeByStatus.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	employeeByStatus.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let employees = JSON.parse(this.responseText);
			console.log(employees);
			
			for (i in employees) {
				N = employees[i];
				let row = document.createElement("tr");
					 
//					document.getElementById("namef").innerHTML = "First Name: "
//							+ N.First_Name + "," + " Last Name: " + N.Last_Name
//							+ "," + " Email: " + N.Email + ","
//							+ " Reimbursement Status: " + N.RI;
					
					let fname = document.createElement("td");
					 let name = document.createTextNode(N.First_Name);
					 fname.appendChild(name);
					 row.appendChild(fname);
					 document.getElementById("employeeTable").appendChild(row);

					 let lname = document.createElement("td");
					 let Namel = document.createTextNode(N.Last_Name);
					 lname.appendChild(Namel);
					 row.appendChild(lname);
					 document.getElementById("employeeTable").appendChild(row);
								
					 let email = document.createElement("td");
					 let nameEmail = document.createTextNode(N.Email);
					 email.appendChild(nameEmail);
					 row.appendChild(email);
					 document.getElementById("employeeTable").appendChild(row);
					
					 let status = document.createElement("td");
					 let nameStatus = document.createTextNode(N.RI);
					 status.appendChild(nameStatus);
					 row.appendChild(status);
					 document.getElementById("employeeTable").appendChild(row);

//					trHTML += '<tr><td>' + N.First_Name + '</td><td>'
//							+ N.Last_Name + '</td><td>' + N.Email
//							+ '</td><td>' + N.RI + '</td></tr>';
//					document.getElementById("employeeTable")
//							.appendChild(trHTML);
				}
			 // select.addEventListener("click", alert);
			// document.getElementById("employeesNames").appendChild(select);
			// document.getElementById('ajaxText').innerHTML =
			// requestLogin.responseText;

		}
		;

	}
	employeeByStatus.send(`status=${x}`);
}
