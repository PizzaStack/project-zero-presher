var requsetManager = new XMLHttpRequest();

requsetManager.open('GET', 'managers/managers.html');

requsetManager.onreadystatechange = function(){
    if(requsetManager.readyState == 4){
        document.getElementById('ajaxText').innerHTML = requsetManager.responseText;
    }
};

// function getManagerPage(){
//     requsetManager.send();
// }

var getManagerPage = () => requsetManager.send()
