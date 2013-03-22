
public class principal {


	public static void main(String[] args) {
		
		Carro c1 = new CarroNormal("BMP 5988",10,40);
		c1.imprimeKm();
		
		Carro c2 = new CarroFlex("JNY 9410",10,25,20);
		c2.imprimeKm();
		
		System.out.println("Flex - Alcool: " + ((CarroFlex)c2).getCombustivelAlcool() );
		System.out.println("Flex - Gasolina: " + ((CarroFlex)c2).getCombustivelGasolina() );

	}

}
