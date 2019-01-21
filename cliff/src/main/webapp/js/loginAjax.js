var requsetLogin = new XMLHttpRequest();

requsetLogin.open('GET', './templates/login.html');

requsetLogin.onreadystatechange = function(){
    if(requsetLogin.readyState == 4){
        document.getElementById('ajaxText').innerHTML = requsetLogin.responseText;
    }
};

// function getLoginPage(){
//     requsetLogin.send();
// }

var getLoginPage = () => requsetLogin.send()

//getLoginPage();