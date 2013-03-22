
public abstract class Juros {
	
	protected int numero_meses;
	protected double valor;
	protected double percentual;
	
	public Juros(int numero_meses_, double valor_, double percentual_){
		this.numero_meses = numero_meses_;
		this.valor = valor_;
		this.percentual = percentual_;
	}
	
	public abstract double taxa();
	
	public String getTaxa(){
		
//		double taxa = this.valor;
//		
//		for (int x = 1; x <= this.numero_meses; x++){
//			taxa = taxa + (taxa * this.percentual);
//		}
		
		return ("O valor total depois da aplica‹o do juros de: " + this.percentual + " sobre o valor: "
				+ this.valor + " para: " + this.numero_meses + " meses Ž: " +this.taxa());
	}

}
