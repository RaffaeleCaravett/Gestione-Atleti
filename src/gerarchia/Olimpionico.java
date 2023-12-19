package gerarchia;

public class Olimpionico extends Professionista{
	
	protected String nazionalita;
	protected int oro;
	protected int argento;
	protected int bronzo;
	
	public Olimpionico() {
		super();
	}
	
	public Olimpionico(String nome, String specialita, int tessera) {
		super(nome, specialita, tessera);
	}
	
	public Olimpionico(String nome, String specialita) {
		super(nome, specialita);
	}

	public Olimpionico(String nome, String specialita, int tessera, String nazionalita, int oro, int argento, int bronzo) {
		super(nome, specialita, tessera);
		this.nazionalita = nazionalita;
		this.oro = oro;
		this.argento = argento;
		this.bronzo = bronzo;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public int getArgento() {
		return argento;
	}

	public void setArgento(int argento) {
		this.argento = argento;
	}

	public int getBronzo() {
		return bronzo;
	}

	public void setBronzo(int bronzo) {
		this.bronzo = bronzo;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " +  nazionalita + " | " + medagliere();
	}

	/**
	 * 
	 */
	public String medagliere() {
		return "Medaglie: "  + oro + " oro, " + argento + " argento, " + bronzo + " bronzo"; 
	}
	
	

}