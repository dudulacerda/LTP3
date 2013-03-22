
public abstract class Carro {
	
	private String placa;
	private int consumo;
	
	public Carro(String placa, int consumo){
		setPlaca(placa);
		setConsumo(consumo);
	}
	
	public abstract double getKm();
	
	public void imprimeKm(){
		System.out.println(toString());
	}
	
	public String toString(){
		return ("Placa = "+ getPlaca() + " - KM = " + getKm());
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	
}
