function UpdateNameF(){
	var fname = $('#fname').val();
	var updateFname = new XMLHttpRequest();
	
	
	updateFname.open('POST', 'UpdateEmployeeFirstNameServlet', true);
	updateFname.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	updateFname.onreadystatechange = function(){
		
		if(this.readyState == 4 && this.status == 200){	
			let Name = JSON.parse(this.responseText);
			alert("Your First Name is updated to " + Name.First_Name);
			//document.getElementById("fName").innerHTML = Name.First_Name;
//			document.getElementById("fName").innerHTML = newName.First_Name;
//			document.getElementById("lName").innerHTML = newName.Last_Name;
//			document.getElementById("Email").innerHTML = newName.Email;
//			document.getElementById("RI").inneHTML = newName.RI;
			
			
		}
		
	};
	updateFname.send(`First_Name=${fname}`);
}
