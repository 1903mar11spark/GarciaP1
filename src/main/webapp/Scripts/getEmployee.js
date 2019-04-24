window.onload = function() {
    getRequest();
   
    
}
function getRequest(){
    fetch("http://localhost:8084/Project1/getEmployeeA")
	.then(function(response){
	return response.json();
	})
	.then(function(data){
		
		if(data.session === null){
			window.location = "http://localhost:8084/Project1/login";
			
		}
		else{
            console.log(data);
                document.getElementById("eId").value = data.employeeId;
                document.getElementById("inputName").value = data.firstName;
                document.getElementById("inputLastN").value = data.lastName;
                document.getElementById("inputAddress").value = data.address;
                document.getElementById("inputPhone").value = data.phone;
                document.getElementById("inputDOB").value = data.dob;
                document.getElementById("inputCity").value = data.city;
                document.getElementById("inputState").value = data.state;
                document.getElementById("inputZip").value = data.zip;

        }
    });
}



