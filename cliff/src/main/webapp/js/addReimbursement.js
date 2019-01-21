function addReimbursement(){
	var request = $('#request').val();
	var updateFname = new XMLHttpRequest();
	
	
	updateFname.open('POST', 'AddReimbursement', true);
	updateFname.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	updateFname.onreadystatechange = function(){
		
		if(this.readyState == 4 && this.status == 200){	
			let response = this.responseText;
			alert(response);
		}
		
	};
	updateFname.send(`request=${request}`);
}
