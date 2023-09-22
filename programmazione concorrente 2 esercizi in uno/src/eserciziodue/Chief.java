package eserciziodue;

public class Chief{
	gestioneOrdine da_fare=new gestioneOrdine();
	public Chief() {
		
	}
	
	public void incomincia() throws InterruptedException{
		for(int i=0;i<50;i++) {
			while(da_fare.getOccupato(1)==1 && 
					da_fare.getOccupato(2)==1  ){
				Thread.sleep(1000);
			}
			da_fare.setOccupato(1, true);
			Thread.sleep(da_fare.casualtempo(3000,5000));
			da_fare.aggiungiOrdine(cibo_a_caso());
			da_fare.setOccupato(1, false);
		}
	} 
	
	public String cibo_a_caso() {
		switch(da_fare.casualtempo(1, 5)) {
		default: return null;
		case 1: return "pizza magherita";
		case 2: return "bistecca con patate";
		case 3: return "bracciola con insalata";
		case 4: return "porzioni miste di pesce";
		case 5: return "acqua";
		}
	}
}
