
public abstract class Candidato implements Politico{
	
	protected String nome;
	
	public Candidato(String nome){
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
