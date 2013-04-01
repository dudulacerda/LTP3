package modelos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Corretora {

	private static final int TIME = 3000; 

	public static void main(String[] args) {

		Double primeiroValor = 0.0;
		Double preco = 0.0;

		try {
			Socket socket = new Socket("127.0.0.1", 4545);

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out.println("itau");
			preco = Double.parseDouble(in.readLine());
			System.out.println("itau = R$ " + preco);

			primeiroValor = preco;

			out.close(); in.close(); socket.close();
			Thread.sleep(TIME);

		} catch (Exception e) {
			e.printStackTrace();
		}

		while ((primeiroValor * 2) > preco) {
			try {
				Socket socket = new Socket("127.0.0.1", 4545);

				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				out.println("itau");
				preco = Double.parseDouble(in.readLine());
				System.out.println("itau = R$ " + preco);

				emitirOrdem(4646, "itau", preco * 1.2);

				out.close(); in.close(); socket.close();
				Thread.sleep(TIME);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while ((primeiroValor / 2) < preco) {
			try {
				Socket socket = new Socket("127.0.0.1", 4545);

				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				out.println("itau");
				preco = Double.parseDouble(in.readLine());
				System.out.println("itau = R$ " + preco);

				emitirOrdem(4747, "itau", preco * 0.8);

				out.close(); in.close(); socket.close();
				Thread.sleep(TIME);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void emitirOrdem(int porta, String acao, Double valor) {
		try {
			Socket socket = new Socket("127.0.0.1", porta);

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out.println(acao);
			out.println(valor);
			System.out.println(in.readLine());

			out.close(); in.close(); socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
