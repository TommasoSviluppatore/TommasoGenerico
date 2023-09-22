package eserciziouno;

import java.util.*;

import eserciziouno.Main;

public class ProgrammaUno {
	//2000 litri di benzina disponibile
	static long pompa_1_litri=2000;
	//viene controllato per poter sapere se può essere riempita la cisterna principale
	public static boolean puo_riempire=true;
	public static boolean nuove_macchine=false;
	
	//imposta la pompa
	public ProgrammaUno(long pompa) {
		this.pompa_1_litri=pompa;
	}
	
	//imposta la disponibilità ad essere riempita
	public boolean riempimento_si() {return puo_riempire;}
	public boolean nuove_macchine() {return nuove_macchine;}
	public static void riempimento_imposta(boolean a) {puo_riempire=a;}
	public static void aspetta() throws InterruptedException {Thread.sleep(1000); }
	public void setLitriRiman(long pompa) {pompa_1_litri=pompa;}
	public static long getLitriRiman() { return pompa_1_litri; }
	
	
	//programma del benzinaio vero e proprio
	public static void StartWork() throws InterruptedException {

		nuove_macchine=false; long daRiempire=0; Main.finito(false);
		
		System.out.println("\nlitri totali rimanenti: " +  pompa_1_litri);
		
		//crea un nuovo array di 30 macchine
		Macchina[] Cars= new Macchina[3];
		for (int i=0; i<3; i++) { Cars[i] = new Macchina(42); }
		for (int i=0; i<3; i++) { Cars[i].setlitri(0); }
		
		for(int i=0;i<3;i++) {
			//imposta la dispnibilità ad essere rifornito su vera momentaneamete
			System.out.println("\n\n-----------------------Rifornimento macchina "+ (i+1) + "------------------------");
			System.out.println("\n -> litri macchina prima rifornimento " + Cars[i].getlitri());
			//aspetta e blocca la disponibilità
			riempimento_imposta(false);
			aspetta();
			
			//casualizzatore di litri
			for(int j=0; j<1;j++) {
				System.out.println("\n\ntentativo "+ (j+1) +" di riempimento macchina");
				//imposta il versamento
				daRiempire=casualtempo();
				//se la quanità da versare di benzina è troppo grande, prova un'altra volta, altrimenti rinuncia
				if(Cars[i].getlitri()+(long)daRiempire>60 && (((Cars[i].getlitri()+(long)daRiempire))-getLitriRiman()<0)) {
					System.out.println("\n\ntentativo di rifornimento "
							+ "fallito: troppo tanto carburante per macchina o cisterna");
				}else {
					//aspetta
					aspetta();
					//imposta la nuova quanitità di benzina
					Cars[i].setlitri(Cars[i].getlitri()+daRiempire);
					System.out.println("\nRifornimento avvenuto con "
							+ " successo a macchina " + (i+1) + " \nora con "
							+ Cars[i].getlitri() + " litri benzina dispnibili");
				}
				
			}
			//svuola la cisterna e imposta la disponibilità ad essere rifornito su vera
			pompa_1_litri-=daRiempire;
			aspetta();
			riempimento_imposta(true);
			
			
		}
		
		
		System.out.println("\n\n-----------------------FINE------------------------");
		System.out.println("\npetrolio andato in fumo " + pompa_1_litri);
		

		nuove_macchine=true;
		Main.finito(true);
	}
	
	//variatore di riempimento serbatoi
	public static int casualtempo() {
		Random ransomwokeware = new Random();
		int min=20;
		int max=50;
		return ransomwokeware.nextInt(max-min)+min;
	}
}
