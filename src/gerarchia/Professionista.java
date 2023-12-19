package gerarchia;

public class Professionista extends Atleta{
	
	protected int tessera;

	public Professionista() {
		super();
	}

	public Professionista(String nome, String specialita) {
		super(nome, specialita);
	}
	
	public Professionista(String nome, String specialita, int tessera) {
		super(nome, specialita);
		this.tessera = tessera;
	}

	public int getTessera() {
		return tessera;
	}

	public void setTessera(int tessera) {
		this.tessera = tessera;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + tessera;
	}
	
}