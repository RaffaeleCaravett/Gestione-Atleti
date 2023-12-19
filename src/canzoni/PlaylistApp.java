package canzoni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PlaylistApp {
	
	private static Scanner in;
	private static Playlist playlist;
	
	// ....................................................................
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		playlist = new Playlist();
		playlist.popolaCanzoni();
		riga();
		System.out.println("PLAYLIST APP");
		riga();
		
		int scelta = 0;
		
		do {
			
			System.out.println("\nScegli opzione:");
			System.out.println("1. Inserire una canzone in una playlist");
			System.out.println("2. Modificare una canzone esistente");
			System.out.println("3. Cancellare una canzone esistente");
			System.out.println("4. Visualizzare tutta la playlist");
			System.out.println("5. Visualizzare il testo di una canzone scelta");
			System.out.println("6. Visualizzare la canzone che dura di più");
			System.out.println("7. Visualizzare quante canzoni durano almeno 3 minuti");
			System.out.print("0. Per uscire\n> ");
			
			scelta = leggiIntero();
			
			riga();
			
			switch(scelta) {
			
				case 0: System.out.println("Programma terminato"); break;
				
				case 1: inserisciCanzone(); break;
				case 2: modificaCanzone(); break;
				case 3: cancellaCanzone(); break;
				case 4: visualizzaPlaylist(); break;
				case 5: visualizzaTesto(); break;
				case 6: recuperaPiuLunga(); break;
				case 7: visualizzaAlmenoTreMin(); break;
				
				default: System.out.println("Scelta errata");
			
			}
			
			riga();
			
			
		}while(scelta != 0);
		
		
		in.close();
	}

	private static void inserisciCanzone() {

		System.out.print("\nDimmi titolo:\n> ");
		String titolo = in.nextLine();

		System.out.print("Dimmi testo:\n> ");
		String testo = in.nextLine();
		
		System.out.print("Dimmi cantante:\n> ");
		String cantante = in.nextLine();
		
		System.out.print("Dimmi durata:\n> ");
		double durata = leggiDouble();
		
		Canzone c = new Canzone(titolo, testo, cantante, durata);
		
//		playlist.getAlbum().add(c);

		playlist.aggiungi(c);
		
	}

	private static void modificaCanzone() {

		visualizzaPlaylist();
		
		System.out.print("Dimmi posizione da modificare:\n> ");
		int pos = leggiIntero();
		
		Canzone c = playlist.getCanzone(pos);
		
		if(c == null)
			System.out.println("Canzone non trovata");
		else {
		
			System.out.print("Dimmi titolo nuovo:\n> ");
			String titolo = in.nextLine();
			
			c.setTitolo(titolo);
			
		}
		
		visualizzaPlaylist();
		
	}

	private static void cancellaCanzone() {
		visualizzaPlaylist();

	    System.out.println("Scegli la posizione della canzone che vuoi eliminare");

	    int string = in.nextInt();
	    if(string < playlist.getAlbum().size()) {

	        playlist.getAlbum().remove(string);
	        System.out.println("Canzone eliminata");
	    } else {
	        System.out.println("Canzone non trovata");
	}
	    }
	/**
	 * Metodo che permette di visualizzare il contenuto
	 * della playlist
	 */
	private static void visualizzaPlaylist() {

		System.out.println(playlist);

	}

	private static void visualizzaTesto() {

		visualizzaPlaylist();
		 System.out.println("Scegli la posizione della canzone che vuoi visualizzare");

		    int string = in.nextInt();
		    if(string < playlist.getAlbum().size()) {

		       playlist.getAlbum().get(string).visualizzaTest();
		    } else {
		        System.out.println("Canzone non trovata");
		}
	}

	private static void recuperaPiuLunga() {

		 visualizzaPlaylist();

		 
		 playlist.visualizzaPiuLunga().forEach(c->{
			 System.out.println(c.toString());
		 });
		 if( playlist.visualizzaPiuLunga().isEmpty()) {
			 System.out.println("La playlist è vuota");

		 }
	}

	private static void visualizzaAlmenoTreMin() {
		System.out.println("Canzoni con durata >3 min");
System.out.println(playlist.visualizzaAlmenoTreMin());
	}

	/**
	 * Metodo che gestisce la lettura di un intero da tastiera
	 * @return intero letto
	 */
	private static int leggiIntero() {
		
		 while (true) {
	            try {
	            	int scelta;
		scelta = in.nextInt();
		in.nextLine();
		return scelta;
	            } catch (java.util.InputMismatchException e) {
	                in.nextLine();
	                System.out.println("Input non valido. Assicurati di inserire un numero intero valido superiore allo 0.");
	                System.out.print("Riprova: ");
	            }
	        }
	}

	/**
	 * Metodo che permette di gestire l'anomalia nella lettura
	 * del numerico
	 * @return valore letto
	 */
	private static double leggiDouble() {
		
		 while (true) {
	            try {
	            	double durata = in.nextDouble();
		in.nextLine();
		return durata;
	            } catch (java.util.InputMismatchException e) {
	                in.nextLine();
	                System.out.println("Input non valido. Assicurati di inserire un numero intero valido superiore allo 0.");
	                System.out.print("Riprova: ");
	            }
	        }
	}
	private static void riga() {
		System.out.println(".............................................");
	}

}