/* UNIFACS - Ciencia da Computacao 5¼ Semestre
 * LTP3 - Trabalho 1 - Bolsa de Valores
 * Prof.: Uedson Reis
 * 
 * Aluno:  Eduardo Lacerda Souza Junior
 */

package servers;

import modelos.Acao;

public class BolsaValores {
	
	//Cria as 3 instancias de Acao necess‡rias
	static Acao itau = new Acao("itau",13.0);		
	static Acao petro = new Acao("petrobras",27.0);
	static Acao vale = new Acao("vale",19.0);
	

	public static void main(String[] args) {
		
		// Cria a thread que vai chamar o server de preco atual
		Thread valor = new Thread(){
			public void run(){
				//chama o metodo statico que cria o servidor, passando tipo, porta, e as 3 instancias de Acao
				Server.servidor("valor", 4545, itau, petro, vale); 
			}
		};
		valor.start();	// Start na thread valor
		 
		//Cria a thread do server Compra
		Thread efetuaCompra = new Thread(){
			public void run(){
				Server.servidor("compra", 4646, itau, petro, vale);
			}
		};
		efetuaCompra.start();	// Start na thread compra
		
		
		//Cria a thread com o server Venda
		Thread efetuaVenda = new Thread(){
			public void run(){
				Server.servidor("venda", 4747, itau, petro, vale);
			}
		};
		efetuaVenda.start();	//Start na thread venda

	}

}
