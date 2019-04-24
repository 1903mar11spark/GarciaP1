window.onload = function() {
    getRequest();
    document.getElementById("selected").addEventListener("click", displaySingle);
    
}
function getRequest(){
    fetch("http://localhost:8084/Project1/getPendingM")
	.then(function(response){
	return response.json();
	})
	.then(function(data){
		
		if(data.session === null){
			window.location = "http://localhost:8084/Project1/login";
			
		}
		else{
            //console.log(data);
            let counter = 1;
            for (let i = 0 ; i < data.length; i ++) {
                var table =  document.getElementById("rList");
                let row = table.insertRow(0);
                let rId = row.insertCell(0);
                let value =  row.insertCell(1);
                let state =  row.insertCell(2);
                let issued =  row.insertCell(3);
                let auth =   row.insertCell(4);

                //add check box selecting in future iterations
                /*let checkbox = document.createElement('input');
                checkbox.type = "checkbox"; 
                checkbox.name = "name"; 
                checkbox.value = "value"; 
                checkbox.id = counter; 
                
                row.appendChild(checkbox);*/

                row.setAttribute('Id', counter);
                rId.setAttribute('scope', 'row');
                rId.innerHTML = data[i].rId;
                value.setAttribute('scope', 'row');
                value.innerHTML = data[i].rValue;
                state.setAttribute('scope', 'row');
                state.innerHTML = data[i].rState;
                issued.setAttribute('scope', 'row');
                issued.innerHTML = data[i].issued;
                auth.setAttribute('scope', 'row');
                auth.innerHTML = data[i].authDate;
                counter ++;
               // console.log(data[i].rId);
                
        }
    }
    });
}
function displaySingle(){
   //alert("entered the function");
   var num = document.getElementById("inputName").value;
    fetch("http://localhost:8084/Project1/getSingleR")
	.then(function(response){
	return response.json();
	})
	.then(function(data){
        alert("Entered function");
		if(data.session === null){
			window.location = "http://localhost:8084/Project1/login";
			
		}
		else{
            //alert()
            console.log(data);
            document.getElementById("inputId").value = data.rId;
            document.getElementById("inputAmount").value = data.rValue;
            document.getElementById("inputReason").value= data.rDesc;
           // document.getElementById("inputRecipt").innerHTML = data.rImg;
           document.getElementById("inputState").value = data.rState;
        }
    });
}