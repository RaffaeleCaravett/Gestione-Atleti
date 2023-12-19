package gerarchia;

public class Dilettante extends Atleta{

	protected int gareVinte;

	public Dilettante() {
		super();
	}

	public Dilettante(String nome, String specialita) {
		super(nome, specialita);
	}

	public Dilettante(String nome, String specialita, int gareVinte) {
		super(nome, specialita);
		this.gareVinte = gareVinte;
	}

	public int getGareVinte() {
		return gareVinte;
	}

	public void setGareVinte(int gareVinte) {
		this.gareVinte = gareVinte;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " + this.gareVinte;
	}	
	
}