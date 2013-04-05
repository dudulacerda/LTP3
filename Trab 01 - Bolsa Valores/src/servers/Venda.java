package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelos.Acao;

public class Venda {
	
	private String acao;
	private double valor;
	
	public Venda(final Acao itau,final Acao petro,final Acao vale){
		Thread venda = new Thread(){
			public void run(){
				while(true){
					try{
						System.out.println("Venda: Aguardando Conexão..."); 
						ServerSocket serverVenda = new ServerSocket(4747);
						Socket socket = serverVenda.accept();					//Cria o socket quando recebe solicitação de conexão
						
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);	//out para realizar envios de msg
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 	//in para receber msg
						System.out.println("Venda: Conexão Efetuada.");
					
						acao = in.readLine();
						valor = Double.parseDouble(in.readLine());
						
						
						if(acao.equalsIgnoreCase("itau")){  
							itau.enviarOrdemDeVenda(valor);
							} else if(acao.equalsIgnoreCase("petrobras")){
								petro.enviarOrdemDeVenda(valor);
								} else if(acao.equalsIgnoreCase("vale")){
									vale.enviarOrdemDeVenda(valor);
									} 
						
						out.println("Ordem de Venda Efetuada.");
						
						
						in.close();
						out.close();
						socket.close();
						serverVenda.close();
						System.out.println("Venda: Conexão Fechada.");
					} catch (IOException e) {
						e.printStackTrace();
					}// Fim Try/Catch
				}//Fim while
			}//Fim do run
		};//Fim da Thread Compra
		
		venda.start();
		
	}//Fim do construtor compra

}
