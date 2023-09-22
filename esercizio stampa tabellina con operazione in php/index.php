<?php
include 'include/funzioni_php.inc';
echo "<p>"+$_POST['num1']+"<\/p>";
        
if (isset($_POST['andiamo']) /*&& !empty($_GET["num1"])*/) {

	if(   isset($_POST['num1']) && !empty($_POST['num1'])   ){return;}

	$aggiungitore=$_POST['num1'];
	$numero_da_stampare=0;
	$contenuto="";
	$controllo_colore=false;
	$pr_col="#000000";
    $sec_col="#FFFFFF";
	
	$contenuto.="<div id=\"scacchiera\"> <table>";

	for($ciclo1=0; $ciclo1<10;$ciclo1++){
		$contenuto.="<tr>";

		for($ciclo2=0;$ciclo2<2;$ciclo2++){
			$contenuto.="<td>";
			if($controllo_colore==false){
				//$contenuto.="<td height=80px width=80px bgcolor={$col_pri} class=dispari> <p>" + $numero_da_stampare + "<\/p> <\/td>";
				$contenuto.="<td height=80px width=500px bgcolor={$col_pri} class=dispari> <p> ho fatto " + (($aggiungitore) * ($numero_da_stampare)) + "<\/p> <\/td>";

			}else{
				//$contenuto.="<td height=80px width=80px bgcolor={$col_sec} class=pari> <p> " + $numero_da_stampare + "<\/p> <\/td>";
				$contenuto.="<td height=80px width=150px bgcolor={$col_pri} class=dispari> <p> risultato finale: " + $numero_da_stampare + "<\/p> <\/td>";
			}

			$controllo_colore=!$controllo_colore; $numero_da_stampare+=$aggiungitore;
			
			$contenuto.="</td>";
		}

		$contenuto.="</tr>";
	}

	$contenuto.="<table> </div>";
	echo $contenuto;

}else{
	//echo "<p style=\"font-size:40px;font-family:arial;color:red\">Sovraccarico di sistema non accettato<p>";

}
?>