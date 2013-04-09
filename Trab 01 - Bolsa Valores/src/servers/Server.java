/* UNIFACS - Ciencia da Computacao 5º Semestre
 * LTP3 - Trabalho 1 - Bolsa de Valores
 * Prof.: Uedson Reis
 * 
 * Aluno:  Eduardo Lacerda Souza Junior
 */

package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import modelos.Acao;

public class Server {
	
	private static String acao;
	private static double valor;
	private static Map<String,Acao> mapaAcao;  //Colecao que ira guardar as 3 intancias de Acao
	private static PrintWriter out;
	private static BufferedReader in;

	public static void servidor(String tipo,int porta,Acao itau,Acao petro,Acao vale){
		while(true){		//para ser executado infinitamente, fechando e reabrindo as conexoes a cada loop
			try{
				System.out.println(tipo + ": Aguardando Conexão..."); 
				ServerSocket serverSocket = new ServerSocket(porta);
				Socket socket = serverSocket.accept();					//Cria o socket quando recebe solicitação de conexão
						
				out = new PrintWriter(socket.getOutputStream(), true);	//out para realizar envios de msg
				in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 	//in para receber msg
				System.out.println(tipo + ": Conexão Efetuada.");
					
				acao = in.readLine();			//recebe o noem da acao (enviada pela classe corretora)
				
				// So vale para ordens de compra e venda
				if (tipo.equalsIgnoreCase("venda")||tipo.equalsIgnoreCase("compra")){
					valor = Double.parseDouble(in.readLine());		//recebe o valor da enviado por corretora
				}
				
				mapaAcao = new HashMap<String,Acao>();		//Guardo as 3 instancias de acao
				mapaAcao.put(itau.getNome(), itau);
				mapaAcao.put(petro.getNome(), petro);
				mapaAcao.put(vale.getNome(), vale);
				
				Server.efetuaOperacao(tipo);				//realiza a operacao requisitada (valor,compra ou venda)
			
						
				out.println("Ordem de "+ tipo +" Efetuada.");
						
						
				in.close();									//fecha as conexoes
				out.close();
				socket.close();
				serverSocket.close();
				System.out.println(tipo + ": Conexão Fechada.");
				
				} catch (IOException e) {
					e.printStackTrace();
				}// Fim Try/Catch
		}//Fim while
	}//Fim metodo servidor
	
	
	
	private static void efetuaOperacao(String tipo){
		
		if(tipo.equalsIgnoreCase("valor")){					//Verifica se a solicitacao é para o Valor da acao, server 4545
			out.println(((Acao)mapaAcao.get(acao)).getPrecoAtual());
		} else if (tipo.equalsIgnoreCase("venda")){						//Verifica se e solicitaco para efetuar Ordem de Venda, server 4646
			((Acao)mapaAcao.get(acao)).enviarOrdemDeVenda(valor);
		} else if (tipo.equalsIgnoreCase("compra")){					//Verifica se e solicitacao para efetuar Ordem de Compra, server 4747
			((Acao)mapaAcao.get(acao)).enviarOrdemDeCompra(valor);
		}
	}
	
}// Fim classe
