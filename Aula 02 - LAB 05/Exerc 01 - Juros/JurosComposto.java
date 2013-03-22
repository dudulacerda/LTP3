
public class JurosComposto extends Juros {
	
	public JurosComposto(int numero_meses_, double valor_){
		super(numero_meses_,valor_,0.1);
	}

	public JurosComposto(int numero_meses_, double valor_, double percentual_) {
		super(numero_meses_, valor_, percentual_);
	}


	public double taxa() {
		
		return super.valor * Math.pow(1+super.percentual, super.numero_meses);
	}
	
}
