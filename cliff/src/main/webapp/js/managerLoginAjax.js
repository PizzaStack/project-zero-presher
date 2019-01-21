var requsetLogin = new XMLHttpRequest();

requsetLogin.open('GET', './managers/managerlogin.html');

requsetLogin.onreadystatechange = function(){
    if(requsetLogin.readyState == 4){
        document.getElementById('ajaxText').innerHTML = requsetLogin.responseText;
    }
};



var requestManagerLoginPage = () => requsetLogin.send()
//var requestManagerLoginPage = () => requestManagerLogin.send()