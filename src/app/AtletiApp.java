package app;

import java.util.ArrayList;
import java.util.Scanner;

import componenti.ElencoAtleti;
import gerarchia.Atleta;
import gerarchia.Dilettante;
import gerarchia.Olimpionico;
import gerarchia.Professionista;

public class AtletiApp {

	private static Scanner in;
	private static ElencoAtleti elenco;
	
	public static void main(String[] args) {
				
		in = new Scanner(System.in);
		elenco = new ElencoAtleti();
		
		elenco.popolaAtleti();
		
		int scelta = 0;
		
		riga();
		System.out.println("ELENCO ATLETI");
		riga();
		
		
		do {
		
			System.out.println("Scegli opzione:");
			System.out.print("1. aggiungere un atleta all'elenco\n"
					+ "2. visualizzare l'elenco degli atleti nell'ordine in cui sono stati inseriti\n"
					+ "3. visualizzare l'elenco dei soli olimpionici\n"
					+ "4. visualizzare il totale delle medaglie d'oro vinte da atleti di una nazionalità scelta dall'utente\n"
					+ "5. visualizzare un messaggio che indica se due atleti scelti dall'utente hanno lo stesso punteggio \n"
					+ "6. visualizzare un messaggio che indica qual è l'olimpionico migliore tra due atleti scelti dall'utente\n"
					+ "0. uscire dal programma\n> ");
			
			scelta = leggiIntero();
			
			riga();
			
			switch(scelta) {
			
				case 1: aggiungiAtleta(); break;
				case 2: visualizzaAtleti(); break;
				case 3: visualizzaOlimpionici(); break;
				case 4: visualizzaOroNazionalita(); break;
				case 5: visualizzaOlimpioniciUguali(); break;
				case 6: visualizzaOlimpioniciMigliore(); break;

				case 0: System.out.println("Programma terminato"); break;
				
				default: System.out.println("Scelta non valida. Riprovare.");
			
			}
			
			riga();
			
			
		}while(scelta != 0);
		
		in.close();
		
	}

	/**
	 * Metodo che permette di aggiungere un nuovo atleta all'elenco.
	 * Il sistema chiede all'utente la tipologia di atleta che desidera 
	 * e tutte le informazioni di interesse.
	 */
	private static void aggiungiAtleta() {
		
		// chiedo e salvo tipologia di atleta
		System.out.print("Scegli tipologia:\n" +
							"1. Atleta\n2. Dilettante\n3. Professionista\n4. Olimpionico\n> ");
		
		int scelta = leggiIntero();
		
		if(scelta > 0 && scelta <= 4) {
			
			// nome e specialità è comune a tutte le tipologie
			
			System.out.print("\nDimmi nome\n> ");
			String nome = in.nextLine();
			
			System.out.print("\nDimmi specialità\n> ");
			String specialita = in.nextLine();
			
			int gareVinte, tessera;
			
			// in base al tipo chiedo tutte le altre info
			switch (scelta) {
				
				case 1 :
						elenco.aggiungiAtleta(new Atleta(nome , specialita));
						break;
				
				
				case 2:
						System.out.println("\nDimmi gare vinte\n> ");
						gareVinte = leggiIntero();
	
						elenco.aggiungiAtleta(new Dilettante(nome, specialita, gareVinte));
			
						break;

				case 3:
						System.out.println("\nDimmi la tessera\\n> ");
						tessera = leggiIntero();
			
						elenco.aggiungiAtleta(new Professionista(nome, specialita, tessera));
						break;

				
				case 4 :
						System.out.print("\nDimmi la tessera\n> ");
						tessera = leggiIntero();
						
						System.out.print("\nDimmi la nazionalità\n> ");
						String nazionalita = in.nextLine();
						
						System.out.print("\nDimmi quante medaglie oro\n> ");
						int oro = leggiIntero();
						
						System.out.print("\nDimmi quante medaglie argento\n> ");
						int argento = leggiIntero();
						
						System.out.print("\nDimmi quante medaglie bronzo\n> ");
						int bronzo = leggiIntero();
	

						elenco.aggiungiAtleta(new Olimpionico(nome, specialita, tessera, nazionalita, oro, argento, bronzo));
	
						break;
	
			}// switch

		
			
		}
		else
			System.out.println("Scelta non valida");
	}

	/**
	 * Metodo che permette di visualizzare l'elenco degli atleti 
	 * nell'ordine in cui sono stati inseriti 
	 */
	private static void visualizzaAtleti() {
		System.out.println(elenco);
	}

	/**
	 * Metodo che permette di visualizzare gli olimpionici 
	 * eventualmente presenti nell'elenco
	 */
	private static void visualizzaOlimpionici() {

		ArrayList<Olimpionico> olimpionici = elenco.getOlimpionici();
		
		if(olimpionici == null)
			System.out.println("Non ci sono atleti");
		else
			if(olimpionici.isEmpty())
				System.out.println("Non ci sono olimpionici");
			else {
				int i = 0;
				for(Olimpionico o : olimpionici)
					System.out.println(i++ + ". " + o);
			}
		
	}

	/**
	 * Metodo che visualizza il totale medaglie d'oro degli
	 * olimpionici di una nazionalità scelta dall'utente
	 */
	private static void visualizzaOroNazionalita() {

		System.out.print("Dimmi nazionalità\n> ");
		String nazionalita = in.nextLine();
		
		System.out.println("La nazione "+ nazionalita + " ha ottenuto un totale di " + elenco.getOroNazionalita(nazionalita) +" medaglie d'oro");
		
	}

	/**
	 * Metodo che visualizza un messaggio che indica se due
	 * olimpionici scelti dall'utente sono uguali
	 */
	private static void visualizzaOlimpioniciUguali() {

visualizzaOlimpionici();
System.out.print("\nDigita l'indice del primo olimpionico\n> ");
int indice1 = leggiIntero();
visualizzaOlimpionici();
System.out.print("\nDigita l'indice del secondo olimpionico\n> ");
int indice2 = leggiIntero();
if(indice1<elenco.getOlimpionici().size()&&indice2<elenco.getOlimpionici().size()) {
	Olimpionico uno = elenco.getOlimpionici().get(indice1);
Olimpionico due = elenco.getOlimpionici().get(indice2);

if(uno!=null && due !=null && uno.getArgento()+uno.getBronzo()+uno.getOro()==due.getArgento()+due.getBronzo()+due.getOro()) {
	System.out.println("I due olimpionici hanno lo stesso punteggio");
}else {
	System.out.println("Gli olimpionici non hanno lo stesso punteggio.");
}
}else {
	System.out.println("Inserisci degli indici validi");
}

	}

	/**
	 * Metodo che visualizza un messaggio che indica quale
	 * olimpionico è migliore tra i due scelti dall'utente
	 */
	private static void visualizzaOlimpioniciMigliore() {

		// TODO 
		
	}
	
	/**
	 * Metodo che gestisce la lettura da tastiera di un valore intero e "corregge"
	 * il bug del metodo nextInt
	 * @return valore letto
	 */
	private static int leggiIntero() {
		int scelta;
		scelta = in.nextInt();
		in.nextLine();
		return scelta;
	}

	/**
	 * Metodo che permette di visualizzare una riga composta da punti
	 */
	private static void riga() {
		System.out.println("...........................................................");
	}
	
}
