window.onload = function () {
    document.getElementById("selected").addEventListener("click", displaySingle);

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
                document.getElementById("inputId").value = data.rId;
                document.getElementById("inputAmount").innerText = "$ " + data.rValue;
                document.getElementById("inputReason").innerText= data.rDesc;
                // document.getElementById("inputRecipt").innerHTML = data.rImg;
                //document.getElementById("inputState").value = data.rState;
            }
        });
}