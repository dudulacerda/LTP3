
public class Eleicao {
	
	public static void main(String[] args){
		
		Prefeito pele = new Prefeito("Pelegrino");
		Prefeito neto = new Prefeito("Neto");
		Prefeito netinho = new Prefeito("Netinho Poderoso");
		
		Vice celia = new Vice("Celia",neto);
		Vice ACM = new Vice("ACM",netinho);
		
		Partido dem = new Partido("DEM",neto); 
		
		
		pele.Voto();
		pele.Voto();
		neto.Voto();
		neto.Voto();
		celia.Voto();
		netinho.Voto();
		ACM.Voto();
		
		dem.Voto();
		dem.Voto();
	
		
		System.out.println("O candidato "+pele.getNome()+" teve "+pele.ContaVoto()+" votos.");
		System.out.println("O candidato "+neto.getNome()+" teve "+neto.ContaVoto()+" votos.");
		System.out.println("A vice "+celia.getNome()+" teve "+celia.ContaVoto()+" votos." );
		
		System.out.println("Votos de "+netinho.nome+" = "+netinho.getQtdVotos());
		
		System.out.println("Vice de Neto = "+neto.getMeuVice().nome);
		System.out.println("Partido de = "+neto.getMeuPartido().getNome());
	}
}
