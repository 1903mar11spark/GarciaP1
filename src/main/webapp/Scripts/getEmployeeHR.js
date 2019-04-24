window.onload = function () {
    getEmployees();
    document.getElementById("selected").addEventListener("click", displaySingle);

}

function getEmployees() {
    fetch("http://localhost:8084/Project1/getAllEmp")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {

            if (data.session === null) {
                window.location = "http://localhost:8084/Project1/login";

            }
            else {
                //console.log(data);
                let counter = 1;
                for (let i = 0; i < data.length; i++) {
                    var table = document.getElementById("rList");
                    let row = table.insertRow(0);
                    let eId= row.insertCell(0);
                    let fname = row.insertCell(1);
                    let lname = row.insertCell(2);
                    let dept = row.insertCell(3);

                    //add check box selecting in future iterations
                    /*let checkbox = document.createElement('input');
                    checkbox.type = "checkbox"; 
                    checkbox.name = "name"; 
                    checkbox.value = "value"; 
                    checkbox.id = counter; 
                    
                    row.appendChild(checkbox);*/

                    row.setAttribute('Id', counter);
                    eId.setAttribute('scope', 'row');
                    eId.innerHTML = data[i].employeeId;
                    fname.setAttribute('scope', 'row');
                    fname.innerHTML = data[i].firstName;
                    lname.setAttribute('scope', 'row');
                    lname.innerHTML = data[i].lastName;
                    dept.setAttribute('scope', 'row');
                    dept.innerHTML = data[i].subordinate;
    
                    counter++;
                    // console.log(data[i].rId);

                }
            }
        });
}
function displaySingle() {
  
    var num = document.getElementById("eId").value;
    console.log(num);
   fetch("http://localhost:8084/Project1/getSingleE?eIds=" + num)
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            //alert("Entered function");
            if (data.session === null) {
                window.location = "http://localhost:8084/Project1/login";

            }
            else {
                //alert()
                console.log(data);
                document.getElementById("inputName").value = data.employeeId;
                document.getElementById("inputLastN").value = data.firstName;
                document.getElementById("exampleFormControlSelect1").value = data.title;
                document.getElementById("inputDepartment").value = data.subordinate;
                document.getElementById("inputPhone").value = data.phone;
                document.getElementById("inputDOB").value = data.dob;
                document.getElementById("inputHire").value = data.hireDate;
                document.getElementById("inputAddress").value = data.address;
                document.getElementById("inputCity").value = data.city;
                document.getElementById("inputState").value = data.state;
                document.getElementById("inputZip").value = data.zip;
            }
        });
}