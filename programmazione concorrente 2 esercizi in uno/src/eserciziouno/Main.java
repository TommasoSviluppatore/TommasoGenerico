package eserciziouno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import eserciziouno.ProgrammaUno;

public class Main{

	//se questo diventa vero allora il programma può finire tranqueillamente
	static boolean has_finished=false;
	
	//inizio
	public static void main (String Args[]) throws InterruptedException {
		
		//avvia in sottofondo il thread del distributore
		Thread insottofondo=new Thread(() -> { Thread thread = new Thread(altro_lavoro()); });
		Thread insottofondo2=new Thread(() -> { Thread thread = new Thread(altro_lavoro2()); });
		ProgrammaUno eseguisciii = new ProgrammaUno(2000);
		
		while(eseguisciii.getLitriRiman()<=0 && eseguisciii.nuove_macchine()) {
			insottofondo.start();
			insottofondo2.start();
			insottofondo.join();
			insottofondo2.join();
			Thread.sleep(5000);
		}
		
		while(!has_finished) {
			Thread.sleep(1000);
		}
		insottofondo.interrupt(); insottofondo2.interrupt();
	}
	
	
	//imposta la variabile che ha finito a vera
	public static void finito(boolean a) {has_finished=a;}
	public static boolean finito2() {return has_finished;}
	
	//avvia il thread della bezinatura
	public static Runnable altro_lavoro() {
		ProgrammaUno eseguisci = new ProgrammaUno(2000);
		try {
			eseguisci.StartWork();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//avvia il trhead della cisterna
	public static Runnable altro_lavoro2() {
		Riempimento eseguisci2 = new Riempimento();
		try {
			eseguisci2.riempi_cisterna();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}