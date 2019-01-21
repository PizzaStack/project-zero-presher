
    var employeeButtonOpacity = document.getElementById('employee-button');
    var managerButtonOpacity = document.getElementById('manager-button');

    employeeButtonOpacity.addEventListener('mouseover', function(){
        employeeButtonOpacity.style.opacity =  1;
    });
    employeeButtonOpacity.addEventListener('mouseout', function(){
        employeeButtonOpacity.style.opacity = .5;
    });
    managerButtonOpacity.addEventListener('mouseover', function(){
        managerButtonOpacity.style.opacity = 1;
    });
    
    managerButtonOpacity.addEventListener('mouseout', function(){
        managerButtonOpacity.style.opacity = .5;
    });
    
    let showEmployeeFnameUpdateForm = document.getElementById('.first');
    let fnameUpdate = document.getElementById('#fnameForm');
    showEmployeeFnameUpdateForm.addEventListener('click', function(){
    	fnameUpdate.style.display = 'block';
    });
    $(document).ready(function(){
		  $(".first").click(function(){
		    $("#fnameForm").toggle();
		  });
		});
    
    // Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
