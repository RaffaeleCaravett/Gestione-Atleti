package canzoni;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	
	private ArrayList<Canzone> album;

	public Playlist() {
		super();
		this.album = new ArrayList<Canzone>();
	}

	public Playlist(ArrayList<Canzone> album) {
		super();
		this.album = album;
	}

	public ArrayList<Canzone> getAlbum() {
		return album;
	}

	public void setAlbum(ArrayList<Canzone> album) {
		this.album = album;
	}

	/**
	 * Metodo che restituisce lo stato dell'oggetto
	 * @return stringa che contiene tutte le canzoni, segnalandone
	 * una per riga e indicandone la posizione, un messaggio di cortesia
	 * in caso in cui l'album sia vuoto
	 * 
	 */
	@Override
	public String toString() {
		
		if(this.album.isEmpty())
			return "Non ci sono canzoni";
		
		String canzoni = "";
		
		// for (int i=0; i<album.size(); i++) {
		// 		canzoni += i+". "+album.get(i)+"\n";
		// }
		
		int i=0;
		for (Canzone c : album)
			canzoni += i++ + ". " + c.toString() +"\n";

		return canzoni;
		
	}

	/**
	 * Metodo che permette di aggiungere una canzone all'album
	 * @param c canzone da aggiungere
	 */
	public void aggiungi(Canzone c) {
		// + add(E) : boolean
		this.album.add(c);
	}

	/**
	 * Metodo che restuisce la canzone che occupa la posizione cercata
	 * @param pos canzone da recuperare
	 * @return canzone se esistente, null in caso di posizione non valida
	 */
	public Canzone getCanzone(int pos) {
		
		if(pos < 0 || pos > album.size())
			return null;
		
		return album.get(pos);
		
	}


	
	/**
	* Metodo che permette di popolare la lista con canzoni di default
	*/
	public void popolaCanzoni() {

	album.add(new Canzone("Miss You", "like Jack and Sally", "Blink 182", 3.5));
	album.add(new Canzone("Thriller", "thrillerrrrrr", "Michael Jackson", 7.5));
	album.add(new Canzone("Insta Lova", "insta lovaaaa insta lovaaa", "Marracash", 2));
	album.add(new Canzone("Wonderwall", "wonderwall", "Oasis", 5.5));
	album.add(new Canzone("A me mi piace o blues", "A me mi piace o blues", "Pino Daniele", 1.5));
	album.add(new Canzone("GFY", "so tell me what you want", "Blackbear", 5.5));
	album.add(new Canzone("Alba chiara", "Respiri piano per non far rumoreeee", "Vasco", 5.5));
	album.add(new Canzone("Momenti no", "quanti momenti noooo", "Fabri Fibra", 7.5));
	album.add(new Canzone("Soft and wet", "you are soft and wet", "Prince", 5.5));
	album.add(new Canzone("Male", "m'piett a me ce sta o nomm tuoij", "Rosaria Miraggio", 5.5));
	album.add(new Canzone("Nothing else matter", "and nothing else matter", "Metallica", 5.5));
	album.add(new Canzone("Vertigini", "un giorno il mondo l'ha fatto tondo affinché tutto torni", "Tedua", 5.5));
	album.add(new Canzone("Lemon tree", "just a yellow tree", "Foolsgarden", 5.5));
	album.add(new Canzone("Pistole nella Gucci", "fanno rattatatta", "Niko Pandetta", 5.5));
	album.add(new Canzone("Il cielo nella stanza", "ehm no", "Salmo", 3.05));

	}
	public int visualizzaAlmenoTreMin() {
		List<Canzone> canzoniList = new ArrayList<Canzone>();	

	getAlbum().forEach(c->{
		if(c.getDurata()>3) {
			canzoniList.add(c);
		}
		});

		if(canzoniList.isEmpty()) {
return 0;
}else {
		return canzoniList.size();	
		}
	}
	public List<Canzone> visualizzaPiuLunga() {
	    List<Canzone> album = getAlbum();
	    List<Canzone> piùLunghe = new ArrayList<>();

	    if (!album.isEmpty()) {
	        Canzone canzone = album.get(0);

	        for (Canzone c : album) {
	            if (c.getDurata() > canzone.getDurata()) {
	                canzone = c;
	                piùLunghe.clear();  
	                piùLunghe.add(c);
	            } else if (c.getDurata() == canzone.getDurata()) {
	                piùLunghe.add(c);  
	            }
	        }

	        return piùLunghe;
	    } else {
	        return new ArrayList<>();  
	    }
	}
}