
public class AplicaJuros {
	
	private Juros juros;
	public static final int SIMPLES=1;
	public static final int COMPOSTO=2;
	
	public AplicaJuros(int tipo, int numero_meses_, double valor_){
		
		if (tipo == COMPOSTO){
			JurosComposto varComposto = new JurosComposto(numero_meses_,valor_);
			this.juros = varComposto;
		} else if (tipo == SIMPLES){
			JurosSimples varSimples = new JurosSimples(numero_meses_,valor_);
			this.juros = varSimples;
		}
	}
	
	public Juros getJuros(){
		return this.juros;
	}
	
	public static void main (String args[]){
		
		AplicaJuros ap = new AplicaJuros(AplicaJuros.COMPOSTO,3,100);
		AplicaJuros ap1 = new AplicaJuros(AplicaJuros.SIMPLES,3,100);
		
		System.out.println("AP = " + ap.getJuros().getTaxa());
		System.out.println("AP1 = " + ap1.getJuros().getTaxa());
		System.out.println("Total de Juros AP1 = " + ((JurosSimples) ap1.getJuros()).getTotalJuros());
		
	}

}
