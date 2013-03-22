
public class Partido implements Politico {
	
	private String nome;
	private Prefeito meuPrefeito;
	
	public Partido(String nome, Prefeito prefeito){
		this.setNome(nome);
		this.meuPrefeito = prefeito;
		meuPrefeito.setMeuPartido(this);
	}

	@Override
	public void Voto() {
		this.getMeuPrefeito().Voto();
	}

	@Override
	public int ContaVoto() {
		return this.getMeuPrefeito().ContaVoto();
	}

	public Prefeito getMeuPrefeito() {
		return meuPrefeito;
	}

	public void setMeuPrefeito(Prefeito meuPrefeito) {
		this.meuPrefeito = meuPrefeito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
	
}
