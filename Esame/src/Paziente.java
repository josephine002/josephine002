public class Paziente {
	private String nome;
	private char sesso;
	
	public Paziente(String nome, char sesso) {
		super();
		this.nome = nome;
		this.sesso = sesso;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
		@Override
	public String toString() {
		return "Paziente [nome=" + nome + ", sesso=" + sesso + "] " ;
	}
}
