package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelos.Acao;

public class Valor {
	
	// P.S Comportamento de final em threads?
		
	public Valor(final Acao itau,final Acao petro,final Acao vale){
		Thread valor = new Thread(){  // Thread que vai retornar o valor atual de uma a��o requeisitada pelo cliente
			public void run(){
				
				String nomeAcao = new String();
				
				while(true){  // Loop infinito para realizar uma opera��o, fechar e ficar pronto novamente para uma nova conex�o
					try{
						System.out.println("Valor: Aguardando Conex�o..."); 
						ServerSocket serverValor = new ServerSocket(4545);
						Socket socket = serverValor.accept();					//Cria o socket quando recebe solicita��o de conex�o
						
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);	//out para realizar envios de msg
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 	//in para receber msg
						System.out.println("Valor: Conex�o Efetuada.");
						
						nomeAcao = new String(in.readLine());   //Aguarda a msg do cliente com o nome da a��o
						
						if(nomeAcao.equalsIgnoreCase("itau")){  //Compara o nome da a��o, para chamar o objeto correspondente
							out.println(itau.getPrecoAtual());
						} else if(nomeAcao.equalsIgnoreCase("petrobras")){
							out.println(petro.getPrecoAtual());
						} else if(nomeAcao.equalsIgnoreCase("vale")){
							out.println(vale.getPrecoAtual());
						} 
						
						
						out.close();		
						in.close();
						serverValor.close();
						socket.close();			//Fecha as conex�es.
						System.out.println("Valor: Conex�o Fechada.");
						} catch (IOException e) {
							e.printStackTrace();
						}// Fim Try/Catch
				}// Fim do While
			}//Fim do RUN
			
		};//Fim da Thread valor
		
		valor.start();  // Inicia a thread que retorna o valor atual da a��o

	}// Fim do construtor
	

}//Fim da classe Valor
