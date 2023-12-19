package canzoni;

public class Canzone {
	
	private String titolo;
	private String testo;
	private String cantante;
	private double durata;
	
	public Canzone() {
		super();
	}

	public Canzone(String titolo, String testo, String cantante, double durata) {
		super();
		this.titolo = titolo;
		this.testo = testo;
		this.cantante = cantante;
		this.durata = durata;
	}

	public Canzone(String titolo) {
		super();
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	

	public String getCantante() {
		return cantante;
	}

	public void setCantante(String cantante) {
		this.cantante = cantante;
	}

	public double getDurata() {
		return durata;
	}

	public void setDurata(double durata) {
		this.durata = durata;
	}

	@Override
	public String toString() {
		return "titolo : " +titolo + " | "+ "testo :" + testo + " | " + "cantante :" + cantante + " | " + " durata :"  + durata;
	}
	
	public void visualizzaTest() {
		System.out.println(testo);
	}
	

}
