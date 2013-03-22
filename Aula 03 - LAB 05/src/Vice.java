
public class Vice extends Candidato{
	
	private Prefeito meuPrefeito;

	public Vice(String nome,Prefeito prefeito) {
		super(nome);
		this.meuPrefeito = prefeito;
		meuPrefeito.setMeuVice(this);
	}
	
	@Override
	public void Voto() {
		meuPrefeito.Voto();
	}

	@Override
	public int ContaVoto() {
		return this.meuPrefeito.ContaVoto();
	}

	public Prefeito getMeuPrefeito() {
		return meuPrefeito;
	}

	public void setMeuPrefeito(Prefeito meuPrefeito) {
		this.meuPrefeito = meuPrefeito;
	}
	
	

}
