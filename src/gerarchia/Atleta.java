package gerarchia;

public class Atleta {

	protected String nome;
	protected String specialita;
	
	public Atleta() {
		super();
	}

	public Atleta(String nome, String specialita) {
		super();
		this.nome = nome;
		this.specialita = specialita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSpecialita() {
		return specialita;
	}

	public void setSpecialita(String specialita) {
		this.specialita = specialita;
	}

	@Override
	public String toString() {
		return nome + " | " + specialita;
	}

	
}