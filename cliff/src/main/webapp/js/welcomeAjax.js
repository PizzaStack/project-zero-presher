var requestEmployeeInfo = new XMLHttpRequest();

requestEmployeeInfo.open('POST', 'UserServlet', true);

requestEmployeeInfo.onreadystatechange = function(){
	
    if(requestEmployeeInfo.readyState == 4 && requestEmployeeInfo.status == 200){
		let employeeInfo = JSON.parse(this.responseText);
		
		console.log(employeeInfo.fname);
		document.getElementById("firstName").innerHTML = employeeInfo.fname;
		document.getElementById("lastName").innerHTML = employeeInfo.lname;
		document.getElementById("email").innerHTML = employeeInfo.email;
		document.getElementById("status").innerHTML = employeeInfo.ri;
		
    	// txt += "<table border='1'>"
    	//     for (x in employeeInfo) {
    	//       txt += "<tr><td>" + employeeInfo[x] + "</td></tr>";
    	//     }
    	//     txt += "</table>" 
    	//     document.getElementById("ajaxText").innerHTML = txt;
    	    
    	     }
    
};

var seeInfo = () => requestEmployeeInfo.send()


