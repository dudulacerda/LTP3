package servers;

import modelos.Acao;

public class BolsaValores {
	
	static Acao itau = new Acao("itau",13.0);		
	static Acao petro = new Acao("petrobras",27.0);
	static Acao vale = new Acao("vale",19.0);
	

	public static void main(String[] args) {
		
		Valor retornaValor = new Valor(itau,petro,vale); //Cria um objeto e vai criar uma thread com o socket
		
		Compra efetuaCompra = new Compra(itau,petro,vale);
		
		Venda efetuaVenda = new Venda(itau,petro,vale);
		
		
		
	}

}
