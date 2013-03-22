
public class Prefeito extends Candidato{
	
	private int qtdVotos;
	private Vice meuVice;
	private Partido meuPartido;

	public Prefeito(String nome) {
		super(nome);
	}
	

	@Override
	public void Voto() {
		this.setQtdVotos(++qtdVotos);
	}	
	
	@Override
	public int ContaVoto() {
		return this.getQtdVotos();
	}

	public int getQtdVotos() {
		return qtdVotos;
	}

	public void setQtdVotos(int votos) {
		this.qtdVotos = votos;
	}

	public Vice getMeuVice() {
		return meuVice;
	}

	public void setMeuVice(Vice meuVice) {
		this.meuVice = meuVice;
	}


	public Partido getMeuPartido() {
		return meuPartido;
	}


	public void setMeuPartido(Partido meuPartido) {
		this.meuPartido = meuPartido;
	}
	
	
	
}
