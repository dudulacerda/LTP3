
public class Acao {

	private String nome;
	private Double precoAtual;
	private Double ordemDeCompra = -1.0;
	private Double ordemDeVenda = 0.0;

	public Acao(String nome, Double precoAtual) {
		this.nome = nome;
		this.precoAtual = precoAtual;
	}

	public void enviarOrdemDeCompra(Double valor) {
		if (valor > ordemDeCompra) {
			ordemDeCompra = valor;
		}

		try { // Espere por 3 segundos
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarOrdemDeVenda(Double valor) {
		if (ordemDeVenda == 0.0) {
			ordemDeVenda = valor;
		} else if (valor < ordemDeVenda) {
			ordemDeVenda = valor;
		}

		try { // Espere por 3 segundos
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarPrecoAtual() {
		if (ordemDeCompra >= ordemDeVenda) {
			precoAtual = (ordemDeCompra + ordemDeVenda) / 2;
		}

		try { // Espere por 4 segundos
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(nome+" = "+ precoAtual);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
