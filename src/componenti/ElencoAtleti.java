package componenti;

import java.util.ArrayList;

import gerarchia.Atleta;
import gerarchia.Dilettante;
import gerarchia.Olimpionico;
import gerarchia.Professionista;

public class ElencoAtleti {

	/*
	 * Atleta è superclasse della nostra gerarchia e di 
	 * conseguenza ci permette di ottenere un array che
	 * 		> resta omogeneo nei dati (tutti gli elementi sono
	 * 		  di tipo Atleta)  
	 * 		> può contenere istanze di Atleta e di un qualunque
	 * 		  tipo figlio (che ne eredita e specializza il codice)
	 */
	private ArrayList<Atleta> atleti;

	// .............................................................
	
	public ElencoAtleti() {
		super();
		this.atleti = new ArrayList<Atleta>();
	}

	public ElencoAtleti(ArrayList<Atleta> atleti) {
		super();
		this.atleti = atleti;
	}

	public ArrayList<Atleta> getAtleti() {
		return atleti;
	}
	

	public void setAtleti(ArrayList<Atleta> atleti) {
		this.atleti = atleti;
	}
	
	// .............................................................
	
	/**
	 * Metodo che restituisce una descrizione testuale dell'oggetto
	 * @return una stringa che contiene tutti gli atleti: uno per riga, 
	 * segnalando la posizione occupata nell'elenco; messaggi di cortesia
	 * in caso non ci siano atleti (o null da controllare nel chiamante)
	 */
	@Override
	public String toString() {
	
		if(atleti.isEmpty())
			return "Non ci sono atleti";
		
		String elenco = "";
		
		int i = 0;
		
		for(Atleta a : atleti)
			elenco += i++ + ". " + a + "\n";
		
		return elenco;
	
	}

	/**
	 * Metodo che permette di aggiungere un atleta all'array
	 * @param atleta da inserire
	 * 
	 * Salvo l'inserimento di controlli più specifici, usiamo
	 * un unico metodo il cui parametro ci consente di gestire
	 * le varie casistiche
	 * 		> un oggetto di tipo Genitore può contenere
	 * 		  un'istanza di sè stesso o di un qualunque figlio
	 */
	public void aggiungiAtleta(Atleta atleta) {
		atleti.add(atleta);
	}
	
	/**
	 * Metodo che permette di salvare nell'elenco degli atleti di default
	 * >> in base ai test possiamo aggiungere atleti con valori comodi per
	 * 	  valutare tutte le casistiche specifiche del caso
	 */
	public void popolaAtleti() {

		atleti.add(new Atleta("Atleta 1", "Specialita"));
		atleti.add(new Dilettante("Dilettante 1", "Specialita", 5));
		atleti.add(new Dilettante("Dilettante2", "Specialita", 5));
		atleti.add(new Atleta("Atleta 2", "Specialita"));
		atleti.add(new Atleta("Atleta 3", "Specialita"));
		atleti.add(new Dilettante("Dilettante 2", "Specialita", 5));
		atleti.add(new Professionista("Professionista 1", "Sport 2", 123));
		atleti.add(new Professionista("Professionista 2", "Sport 2", 123));
		atleti.add(new Olimpionico("Olimpionico 1","Sport 1", 11, "Nazionalita", 3, 4, 5));
		atleti.add(new Olimpionico("Olimpionico 2","Sport 1", 11, "Nazionalita", 3, 4, 5));
		atleti.add(new Olimpionico("Olimpionico 3","Sport 1", 11, "Nazionalita", 7, 4, 5));
		atleti.add(new Olimpionico("Olimpionico 4","Sport 1", 11, "Nazionalita 2", 7, 4, 5));
		atleti.add(new Olimpionico("Olimpionico 5","Sport 1", 11, "Nazionalita 2", 7, 4, 5));
		atleti.add(new Atleta("Atleta 4", "Specialita"));
		atleti.add(new Dilettante("Dilettante 3", "Specialita", 5));
		
	}

	// + getOlimpionici() : ArrayList<Olimpionico>
	
	public ArrayList<Olimpionico> getOlimpionici(){
		
		if(this.atleti.isEmpty())
			return null;
		
		ArrayList<Olimpionico> olimpionici = new ArrayList<Olimpionico>();
		
		for(Atleta a : this.atleti)
			if(a instanceof Olimpionico)
				olimpionici.add((Olimpionico) a);
		
		return olimpionici;
		
	}
	
	
	// + getOroNazionalita(String nazionalita) : int

	public int getOroNazionalita(String nazionalita) {
		
		ArrayList<Olimpionico> olimpionici = getOlimpionici();
		
		if(olimpionici == null || olimpionici.isEmpty())
			return 0;
		
		int totOro = 0;
		
		for(Olimpionico o : olimpionici)
			if(o.getNazionalita().equalsIgnoreCase(nazionalita))
				totOro += o.getOro();
		
		return totOro;
		
}
}
