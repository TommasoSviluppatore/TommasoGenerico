package eserciziodue;

import java.util.*;

public class Scaffale {
	public String ordine="";
	public String getOrdine() {  return ordine;}
	public void setOrdine(String a) {ordine=a;}
	public Scaffale(String a) {
		this.ordine=a;
	}
}

class gestioneOrdine{
	static boolean occupato_chief,occupato_commesso;
	
	public void setOccupato(int i,boolean a) {
		switch(i) {
			case 1: occupato_chief=a; break;    case 2: occupato_commesso=a; break;
			default: break; } 
	}
	
	public int getOccupato(int i) {
		int a=occupato_chief? 1:0;
		int b = occupato_commesso? 1:0;
		switch(i) {   case 1: return a;   case 2: return b;   default: return 3; } 
	}
	
	static List<Scaffale> listaOggetti = new ArrayList<>();
	public gestioneOrdine() {
		
	}
	public static void aggiungiOrdine(String ciao) {
		Scaffale oggettosucc=new Scaffale(ciao);
		listaOggetti.add(oggettosucc);
	}
	public static List<Scaffale> ottieniOrdine() {
		return listaOggetti;
	}
	public static void rimuoviOrdine(String ciao) {
		listaOggetti.removeIf(oggetto -> oggetto.getOrdine().equals(ciao));
	}
	
	public static int casualtempo(int min, int max) {
		Random ransomwokeware = new Random();
		int min=min;
		int max=max;
		return ransomwokeware.nextInt(max-min)+min;
	}
}
