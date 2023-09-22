<?php
include 'include/funzioni_php.inc';
echo "<p>"+$_POST['num1']+"<\/p>";
        
if (isset($_POST['andiamo']) /*&& !empty($_GET["num1"])*/) {

	$numerocicli = $_POST['num1'];
	$numero_da_stampare=0;
	$contenuto="";
	if($numerocicli>1000 || $numerocicli<=0){echo $contenuto.=troppa_roba();}

	for($i=0; $i<$numerocicli+1 && $i<1000 && $i>=1; $i++){
		if($numero_da_stampare % 2 == 0 ){
			$contenuto.=NONpari_numero((int)$numero_da_stampare);
		}else{
			$contenuto.=((int)$numero_da_stampare);
		}
		$numero_da_stampare++;
	}

	echo $contenuto;

}else{
	//echo "<p style=\"font-size:40px;font-family:arial;color:red\">Sovraccarico di sistema non accettato<p>";

}
?>