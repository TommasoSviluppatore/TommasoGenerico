package eserciziodue;

public class Main {


		//se questo diventa vero allora il programma può finire tranqueillamente
		static boolean has_finished=false;
		
		//inizio
		public static void main (String Args[]) throws InterruptedException {
			
			//avvia in sottofondo il thread del distributore
			Thread insottofondo=new Thread(() -> { Thread thread = new Thread(altro_lavoro()); });
			insottofondo.start();
			Thread.sleep(1000);
			//aspetta in secondo e avvia il thread della cisterna
			Thread insottofondo2=new Thread(() -> { Thread thread = new Thread(altro_lavoro2()); });
			insottofondo2.start();
			
			//mentre i 2 thread sono in esecuzione in background, questa stringa tiene
			//il thread del programma sempre in attesa di poter finire verificando
			//ogni secondo che la variabile possa diventare vera
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
			Chief eseguisci = new Chief();
			try {
				eseguisci.incomincia();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		//avvia il trhead della cisterna
		public static Runnable altro_lavoro2() {
			Commesso eseguisci2 = new Commesso();
			try {
				eseguisci2.incomincia();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
