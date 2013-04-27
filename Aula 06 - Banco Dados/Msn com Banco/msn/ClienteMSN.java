package msn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import banco.Conexao;


public class ClienteMSN {
	
	private static Conexao bancoCliente = new Conexao();
	
	public static void main(String[] args) {
		
		try{
		
			//Espera que um cliente se conecte
			//Apos conexao cria um Sicket que representa a mesma
			Socket socket = new Socket("127.0.0.1",4444);
			
			//fluxo de Entrada e Saida
			final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			final InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			
			//Enviando mensagens ao Servidor
			
			System.out.println(in.readLine());
			
			out.println("Cliente: Sou o cliente, requisito conexao!");

			
			Thread recebeMsg = new Thread(){
				public void run(){
					BufferedReader entrada = new BufferedReader(isr);
					try {
						while(true){
							String txt = new String (entrada.readLine());
							System.out.println("Server:"+txt);
							bancoCliente.gravaHistorico("Server", "Cliente", txt);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			};
			
			
			Thread envioMsg = new Thread(){
				public void run(){
					Scanner teclado = new Scanner(System.in);
					while (true){
						System.out.println("Msg2Server: ");
						String txt = new String(teclado.nextLine());
						out.println(txt);
					}
				}
			};
			
			recebeMsg.start();
			envioMsg.start();

		} catch (Exception e){
			System.err.println(e);
			System.exit(-1);
		}
	}
}

