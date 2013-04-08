package servers;

import modelos.Acao;

public class BolsaValores {
	
	static Acao itau = new Acao("itau",13.0);		
	static Acao petro = new Acao("petrobras",27.0);
	static Acao vale = new Acao("vale",19.0);
	

	public static void main(String[] args) {
		
		Thread valor = new Thread(){
			public void run(){
				Server.servidor("valor", 4545, itau, petro, vale);
			}
		};
		valor.start();
		 
		
		Thread efetuaCompra = new Thread(){
			public void run(){
				Server.servidor("compra", 4646, itau, petro, vale);
			}
		};
		efetuaCompra.start();
		
		Thread efetuaVenda = new Thread(){
			public void run(){
				Server.servidor("venda", 4747, itau, petro, vale);
			}
		};
		efetuaVenda.start();
		
		
		
		
	}

}
