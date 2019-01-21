var fileUpload = new XMLHttpRequest();

fileUpload.open('POST', 'FileUploadServlet', true);

fileUpload.onreadystatechange = function(){
	
    if(requestEmployeeInfo.readyState == 4 && requestEmployeeInfo.status == 200){
		
		
    }
    
};

var postFileUpload = () =>fileUpload.send();
	
