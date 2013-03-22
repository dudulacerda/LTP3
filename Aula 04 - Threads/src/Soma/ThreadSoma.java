package Soma;

import java.util.Scanner;

public class ThreadSoma{
	
	private static int TOTAL = 0;
	private static int n = 500;
	
	public static void main(String[] args){
		atividade3();
		atividade2();
		System.out.println("Acabou");
	}
	
	private static void atividade2(){
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					System.out.println(TOTAL);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}	
		};
		
		t1.start();
		
		Scanner teclado = new Scanner(System.in);
		while(true){
			int valor = teclado.nextInt();
			TOTAL += valor;
			
		}
	}
	
	private static void atividade3(){
		
		try{
			Thread t2 = new Thread(){
				public void run(){
					while(true){
						n = n+500;
						try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//System.out.println(n);
					}
				}
			};

			t2.start();
			
			for (int i = 0; i < n; i++){
				System.out.println(i +" "+ n);
				Thread.sleep(1);
			}
			
		} catch (Exception e){}
	}
		
}
	
	


