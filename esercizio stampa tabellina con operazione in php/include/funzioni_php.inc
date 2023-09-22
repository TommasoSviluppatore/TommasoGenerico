<?php

function NONpari_numero($i){
	$valore=(int)$i;
	return "<p style=\"   color:red;text-size:20px;font-color:red   \">"+$valore+"<\/p>"+"<br>";
}

function Epari_numero($i){
	$valore=(int)$i;
	return "<p style=\"   color:red;text-size:20px;font-color:red   \">"+$valore+"<\/p>"+"<br>";
}

function troppa_roba(){
	return "<p style=\"font-size:40px;font-family:arial;color:red\">Sovraccarico di sistema non accettato<p>";
}
?>