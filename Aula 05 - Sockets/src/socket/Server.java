package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
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
			
			out.println("Servidor: Envie sua mensagem");
			
			//System.out.println(in.readLine());
		
			
			Thread t1 = new Thread(){
				public void run(){
					BufferedReader entrada = new BufferedReader(isr);
					try {
						while(true){
							String txt = new String ("Cliente: "+entrada.readLine());
							System.out.println(txt);
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
			
			t1.start();
			envioMsg.start();
			
			
			
			
		} catch (Exception e){
			System.err.println(e);
			System.exit(-1);
		}
		
		
		
		
		
	}

}
