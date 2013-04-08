package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelos.Acao;

public class Server {
	
	private static String acao;
	private static double valor;

	public static void servidor(String tipo,int porta,Acao itau,Acao petro,Acao vale){
		while(true){
			try{
				System.out.println(tipo + ": Aguardando Conexão..."); 
				ServerSocket serverSocket = new ServerSocket(porta);
				Socket socket = serverSocket.accept();					//Cria o socket quando recebe solicitação de conexão
						
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);	//out para realizar envios de msg
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 	//in para receber msg
				System.out.println(tipo + ": Conexão Efetuada.");
					
				acao = in.readLine();			//recebe o noem da acao (enviada pela classe corretora)
				
				// So vale para ordens de compra e venda
				if (tipo.equalsIgnoreCase("venda")||tipo.equalsIgnoreCase("compra")){
					valor = Double.parseDouble(in.readLine());		//recebe o valor da enviado por corretora
				}
				
				// Caso seja para descobrir o Valor da Acao, porta 4545
				if(tipo.equalsIgnoreCase("valor")){
					if(acao.equalsIgnoreCase("itau")){  
						out.println(itau.getPrecoAtual());
						} else if(acao.equalsIgnoreCase("petrobras")){
							out.println(petro.getPrecoAtual());
							} else if(acao.equalsIgnoreCase("vale")){
								out.println(vale.getPrecoAtual());
								}
				}
				
				// Ordem de compra 4646	
				if (tipo.equalsIgnoreCase("venda")){
					if(acao.equalsIgnoreCase("itau")){  
						itau.enviarOrdemDeVenda(valor);
						} else if(acao.equalsIgnoreCase("petrobras")){
							petro.enviarOrdemDeVenda(valor);
							} else if(acao.equalsIgnoreCase("vale")){
								vale.enviarOrdemDeVenda(valor);
								} 
				} 
				
				
				//Ordem de Venda 4747
				if (tipo.equalsIgnoreCase("compra")){
					if(acao.equalsIgnoreCase("itau")){  
						itau.enviarOrdemDeCompra(valor);
						} else if(acao.equalsIgnoreCase("petrobras")){
							petro.enviarOrdemDeCompra(valor);
							} else if(acao.equalsIgnoreCase("vale")){
								vale.enviarOrdemDeCompra(valor);
								}
				}
						
				out.println("Ordem de "+tipo+" Efetuada.");
						
						
				in.close();
				out.close();
				socket.close();
				serverSocket.close();
				System.out.println(tipo + ": Conexão Fechada.");
				
				} catch (IOException e) {
					e.printStackTrace();
				}// Fim Try/Catch
		}//Fim while
	}//Fim metodo servidor
}// Fim classe
