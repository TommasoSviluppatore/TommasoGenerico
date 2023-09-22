var stampaCose=document.getElementById("andiamo").addEventListener("click",creaTabella);

function creaTabella(){
    var xhttp=new XMLHttpRequest();
    xhttp.onload=function(){
        if(this.status==200){
            document.getElementById("risultato").innerHTML=this.response;
        
        }else{
            document.getElementById("risultato").innerHTML="<p>Si è verificato un errore</p>";
        }
    }
    var moltiplicatore=document.getElementByName("num1").value;

    var url="main.php?moltiplicatore="+moltiplicatore;
    xhttp.open("POST",url, true);
    xhttp.send();
}