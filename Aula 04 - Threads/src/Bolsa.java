
public class Bolsa {

	private Acao vale = new Acao("Vale", 50.0);
	
	private Acao petro = new Acao("Petrobras",25.0);

	private void emitirOrdens() {
		
		Thread thread1 = new Thread(){
			public void run(){
				// Por esse bloco em uma Thread
				double valor1 = 45.4;
				while(true) {
					vale.enviarOrdemDeCompra(valor1);
					petro.enviarOrdemDeCompra(valor1);
					valor1 = valor1 +1;
				}
			}
		};
		
		Thread thread2 = new Thread(){
			public void run(){
				// Por esse bloco em outra Thread
				double valor2 = 42.2;
				while(true) {
					vale.enviarOrdemDeVenda(valor2);
					petro.enviarOrdemDeVenda(valor2);
					valor2 = valor2 + 1.5;
				}
			}
		};
		
		thread1.start();
		thread2.start();
	}

	private void iniciarPregao() {
		
		Thread thread3 = new Thread(){
			int loop = 0;
			public void run(){
				// Por esse bloco em uma Thread
				while(true) {
					
					vale.mostrarPrecoAtual();
					petro.mostrarPrecoAtual();
					System.out.println(loop++);
				}
			}
		};
		thread3.start();
	}

	public static void main(String[] args) {
		Bolsa bolsa = new Bolsa();
		bolsa.iniciarPregao();
		bolsa.emitirOrdens();
	}
}
