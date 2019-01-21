var requestLogout = new XMLHttpRequest();

requestLogout.open('POST', './Logout', true);

requestLogout.onreadystatechange = function(){
    if(requestLogout.readyState == 4 && requestLogout.status == 200){
        alert("You Have Signed Out");
        
        	  location.replace("index.html");
        	
    }
};

var getLogoutPage = () => requestLogout.send()

