
public class JurosSimples extends Juros{
	
	
	
	public JurosSimples(int numero_meses_, double valor_){
		this(numero_meses_,valor_,0.1);
	}

	public JurosSimples(int numero_meses_, double valor_, double percentual_) {
		super(numero_meses_, valor_, percentual_);
	}

	
	public double taxa() {
		
		return (super.valor * (1+super.percentual * super.numero_meses));
	}
	
	public double getTotalJuros(){
		return (this.percentual * this.numero_meses * 100);
	}
	
	

}
