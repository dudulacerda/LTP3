package msn;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import banco.Conexao;


public class ServerMSN {
	
	private static Conexao conexBanco = new Conexao();
	

	public static void main(String[] args){
		
		try{
			//cria um servidor na porta 4444
			ServerSocket serverSocket = new ServerSocket(4444);
			
			
			//Espera que um cliente se conecte
			//Apos conexao cria um Sicket que representa a mesma
			final Socket socket = serverSocket.accept();
			
			//fluxo de Entrada e Saida
			final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			final InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			
			//Enviando mensagens ao Cliente
			out.println("Servidor: Sou o servidor, vc esta conectado");
			
			System.out.println(in.readLine());
	
				
			Thread esperaMsg = new Thread(){
				public void run(){
					BufferedReader entrada = new BufferedReader(isr);
					try {
						while(true){
							String txt = new String (entrada.readLine());
							System.out.println("Cliente:"+txt);
							conexBanco.gravaHistorico("Cliente", "Server", txt);
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
						System.out.println("Msg2Cliente: ");
						String txt = new String(teclado.nextLine());
						out.println(txt);
					}
				}
			};
			
			esperaMsg.start();
			envioMsg.start();
			
		} catch (Exception e){
			System.err.println(e);
			System.exit(-1);
		}
			
	}

}
