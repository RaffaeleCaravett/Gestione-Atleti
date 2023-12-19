package canzoni;

import java.util.Scanner;

/**
 * Scrivere un programma che permetta all’utente di inserire i dati relativi 
 * a due canzoni e che in fase successiva visualizzi:
 * 
 * > il titolo delle due canzoni
 * > il testo della seconda canzone
 * > un messaggio che indica quale canzone dura di più 
 * > un messaggio che indica se le due canzoni hanno lo stesso cantante
 * 
 */
public class CanzoneApp {
	
	private static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		System.out.println("CANZONE APP --------------------------------- \n");
		
		Canzone c1 = creaCanzone();
		Canzone c2 = creaCanzone();
		
		
		// 1 visualizzare il titolo delle due canzoni --------------------
		
		System.out.println("\nTitolo 1: " + c1.getTitolo());
		System.out.println("Titolo 2: " + c2.getTitolo());
		
		// 2 visualizzare il testo della seconda canzon2 ------------------
		
		System.out.println("\nTesto 2: " + c2.getTesto());
		
		// 3 un messaggio che indica quale canzone dura di più 
		if(c1.getDurata() == c2.getDurata())
			System.out.println("Hanno la stessa durata");
		else
			if(c1.getDurata() > c2.getDurata())
				System.out.println(c1.getTitolo());
			else
				System.out.println(c2.getTitolo());
		
		// 4 visualizzare un messaggio che indica se le due canzoni 
		// hanno lo stesso cantante
		
		System.out.println("Le due canzoni " + (stessoCanzone(c1, c2) ? "" : "non ") + "hanno lo stesso cantante" );
		
		in.close();
		
	}
	
	/**
	 * Metodo che verifica se due canzoni hanno lo stesso cantante
	 * @param c1 prima canzone 
	 * @param c2 seconda canzone
	 * @return true quando c1 e c2 hanno lo stesso cantante, false altrimenti 
	 */
	private static boolean stessoCanzone(Canzone c1, Canzone c2) {

//		if(c1.getCantante() == c2.getCantante())
//			return true;
		
		/*
		 * + equals(String) : boolean
		 * 		metodo di String che confronta la stringa su cui si invoca
		 * 		il metodo con la stringa parametro
		 * 		@return true quando le due stringhe sono indentiche, false
		 * 		altrimenti
		 * 
		 * 
		 * + equalsIgnoreCase(String) : boolean
		 * 		metodo di String che confronta la stringa su cui si invoca
		 * 		il metodo con la stringa parametro
		 * 		@return true quando le due stringhe hanno gli stessi caratteri
		 * 		indipendentemente dal case, false
		 * 		altrimenti
		 */
		
//		if(c1.getCantante().equals(c2.getCantante()))
//			return true;
//		
//		return false;

		return c1.getCantante().equals(c2.getCantante());
		
	}
	
	

	/**
	 * Metodo che permette di creare una canzone.
	 * L'applicazione chiede all'utente di segnalare
	 * i valori per varie informazioni
	 * 
	 * @return Canzone che contiene i dati
	 */
	private static Canzone creaCanzone() {

		System.out.print("\nDimmi titolo:\n> ");
		String titolo = in.nextLine();

		System.out.print("Dimmi testo:\n> ");
		String testo = in.nextLine();
		
		System.out.print("Dimmi cantante:\n> ");
		String cantante = in.nextLine();
		
		System.out.print("Dimmi durata:\n> ");
		double durata = leggiDouble();
		
		return new Canzone(titolo, testo, cantante, durata);
	}

	
	/**
	 * Metodo che permette di gestire l'anomalia nella lettura
	 * del numerico
	 * @return valore letto
	 */
	private static double leggiDouble() {
		double durata = in.nextDouble();
		in.nextLine();
		return durata;
	}


}