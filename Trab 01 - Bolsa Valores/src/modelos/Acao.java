package modelos;

public class Acao {

	private String nome;
	private Double precoAtual;

	public Acao(String nome, Double precoAtual) {
		this.nome = nome;
		this.precoAtual = precoAtual;
	}

	public void enviarOrdemDeCompra(Double valor) {
		if (valor > precoAtual) {
			precoAtual = valor;
		}
	}

	public void enviarOrdemDeVenda(Double valor) {
		if (precoAtual == 0.0) {
			precoAtual = valor;
		} else if (valor < precoAtual) {
			precoAtual = valor;
		}
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getPrecoAtual() {
		return precoAtual;
	}
}
