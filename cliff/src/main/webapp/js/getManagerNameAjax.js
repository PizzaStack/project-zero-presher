var managersName = new XMLHttpRequest();

managersName.open('POST', 'GetManagersNameServlet', true);

managersName.onreadystatechange = function(){
	
	if(this.readyState == 4 && this.status == 200){
		let manager = JSON.parse(this.responseText);
		
		document.getElementById("user").innerHTML = manager.name;
	}
};

(function(){
	managersName.send()
})()