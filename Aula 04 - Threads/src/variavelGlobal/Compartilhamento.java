package variavelGlobal;

public class Compartilhamento {
	
	static int num = 0;
	
	public static void main(String args[]){
	
		Thread t1 = new Thread(){
			public void run(){
				while(num != 10){
					num = num + 1;
					System.out.println("t1 = "+num);
				}
			}
		};
		
		
		Thread t2 = new Thread(){
			public void run(){
				for(int i = num; i<=10;i++){
					num = i;
					System.out.println("t2 = "+num);
				}	
			}
		};
		
		t1.start();
		t2.start();
		
		
		
		
	}

}
