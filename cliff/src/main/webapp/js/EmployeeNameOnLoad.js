(function(){
	var requestEmployeeInfo = new XMLHttpRequest();

	requestEmployeeInfo.open('POST', 'UserServlet', true);

	requestEmployeeInfo.onreadystatechange = function(){
		
	    if(requestEmployeeInfo.readyState == 4 && requestEmployeeInfo.status == 200){
			let employeeInfo = JSON.parse(this.responseText);
			
			console.log(employeeInfo.fname);
			document.getElementById("user").innerHTML = employeeInfo.fname; 
	    };
	}
	    requestEmployeeInfo.send()
})()
	