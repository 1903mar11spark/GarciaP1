window.onload = function() {
    getRequest();
}
function getRequest(){
    fetch("http://localhost:8084/Project1/getRequest")
	.then(function(response){
	return response.json();
	})
	.then(function(data){
		
		if(data.session === null){
			window.location = "http://localhost:8084/Project1/login";
			
		}
		else{
            console.log(data);
            for (let i = 0 ; i < data.length; i ++) {
				let nTr = document.createElement("tr");
                let nTd = document.createElement("td");
                let value = document.createElement("td");
                let state = document.createElement("td");
                let issued = document.createElement("td");
                let auth =  document.createElement("td");
				nTd.setAttribute('scope', 'row');
                nTd.innerHTML = data[i].rId;
                document.getElementById("rList").appendChild(nTr);
                document.getElementById("rList").appendChild(nTd);
                value.setAttribute('scope', 'row');
                value.innerHTML = data[i].rValue;
                document.getElementById("rList").appendChild(value);
                state.setAttribute('scope', 'row');
                state.innerHTML = data[i].rState;
                document.getElementById("rList").appendChild(state);
                issued.setAttribute('scope', 'row');
                issued.innerHTML = data[i].issued;
                document.getElementById("rList").appendChild(issued);
                auth.setAttribute('scope', 'row');
                auth.innerHTML = data[i].authDate;
                document.getElementById("rList").appendChild(auth);

                console.log(data[i].rId);
                
        }
    }
    });
}
    //getingUser();
   // sendAjaxGet('http://localhost:8084/Project1/dashboardAs', showRequest);



