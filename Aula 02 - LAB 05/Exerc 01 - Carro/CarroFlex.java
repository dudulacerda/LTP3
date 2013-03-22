
public class CarroFlex extends Carro{
	
	int combustivelAlcool;
	int combustivelGasolina;
	
	public CarroFlex(String placa,int consumo, int combustivelAlcool, int combustivelGasolina){
		super(placa,consumo);
		setCombustivelAlcool(combustivelAlcool);
		setCombustivelGasolina(combustivelGasolina);
	}
	
	public CarroFlex(String placa, int consumo) {
		super(placa, consumo);
	}

	public double getKm() {

		return ((super.getConsumo() * 0.7 * getCombustivelAlcool())+(super.getConsumo() * getCombustivelGasolina()));
	}

	public int getCombustivelAlcool() {
		return combustivelAlcool;
	}

	public void setCombustivelAlcool(int combustivelAlcool) {
		this.combustivelAlcool = combustivelAlcool;
	}

	public int getCombustivelGasolina() {
		return combustivelGasolina;
	}

	public void setCombustivelGasolina(int combustivelGasolina) {
		this.combustivelGasolina = combustivelGasolina;
	}
	
	public String toString(){
		return ("Carro Flex " + super.toString());
	}
}
