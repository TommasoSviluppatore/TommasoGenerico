package eserciziouno;

import java.util.Random;

public class Riempimento {
	
	public static void riempi_cisterna() throws InterruptedException {

		ProgrammaUno eseguisci = new ProgrammaUno(2000);
		//continua all'inifito
		
		while(true) {
			Thread.sleep(15000);
			//verifica disponibilità ad essere riempito ogni 15 secondi
			if(eseguisci.riempimento_si()) {
				long variabile = casualtempo();
				//se il serbatoio totale non trabocca (oltre 2 2000 litri) allora riempe
				if(ProgrammaUno.getLitriRiman()+variabile<2000) {
					 eseguisci.pompa_1_litri=ProgrammaUno.getLitriRiman()+variabile;
				}
			  
			}
		}
	}
	
	//casualizzatore di litri 
	public static int casualtempo() {
		Random ransomwokeware = new Random();
		int min=15;
		int max=75;
		return ransomwokeware.nextInt(max-min)+min;
	}
}
