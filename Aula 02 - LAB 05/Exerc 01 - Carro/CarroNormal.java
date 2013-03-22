
public class CarroNormal extends Carro{
	
	private int combustivel;
	
	public CarroNormal(String placa, int consumo, int combustivel){
		super(placa,consumo);
		setCombustivel(combustivel);
	}
	
	public CarroNormal(String placa, int combustivel){
		//super(placa,10);
		//setCombustivel(combustivel);
		
		this(placa, 10, combustivel);  //Mais indicado, evita duplicação de código
	}
	
	public double getKm() {
		
		return (super.getConsumo() * getCombustivel());
	}
	
	public int getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public String toString(){
		return ("Carro Normal" + super.toString());
	}
	
	
	

}
