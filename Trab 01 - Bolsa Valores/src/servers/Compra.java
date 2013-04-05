package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelos.Acao;

public class Compra {
	
	private String acao;
	private double valor;
	
	public Compra(final Acao itau,final Acao petro,final Acao vale){
		Thread compra = new Thread(){
			public void run(){
				while(true){
					try{
						System.out.println("Compra: Aguardando Conexão..."); 
						ServerSocket serverCompra = new ServerSocket(4646);
						Socket socket = serverCompra.accept();					//Cria o socket quando recebe solicitação de conexão
						
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);	//out para realizar envios de msg
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 	//in para receber msg
						System.out.println("Compra: Conexão Efetuada.");
					
						acao = in.readLine();
						valor = Double.parseDouble(in.readLine());
						
						
						if(acao.equalsIgnoreCase("itau")){  
							itau.enviarOrdemDeCompra(valor);
							} else if(acao.equalsIgnoreCase("petrobras")){
								petro.enviarOrdemDeCompra(valor);
								} else if(acao.equalsIgnoreCase("vale")){
									vale.enviarOrdemDeCompra(valor);
									} 
						
						out.println("Ordem de Compra Efetuada.");
						
						
						in.close();
						out.close();
						socket.close();
						serverCompra.close();
						System.out.println("Compra: Conexão Fechada.");
					} catch (IOException e) {
						e.printStackTrace();
					}// Fim Try/Catch
				}//Fim while
			}//Fim do run
		};//Fim da Thread Compra
		
		compra.start();
		
	}//Fim do construtor compra

}//Fim da classe
