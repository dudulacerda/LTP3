package agendaContatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GerenciaContatos {
	
	private List<Contatos> listaContatos = new ArrayList<Contatos>();			//Uma lista que vai aramazenar os contatos

	public GerenciaContatos(){
		
	}
	
	public boolean addContato(Contatos novoContato){
		if(!(this.listaContatos.contains(novoContato))){
			this.listaContatos.add(novoContato);
			return true;
		}
		return false;
	}
	
	public List<Contatos> getListaContatos(){
		return this.listaContatos;
	}
	
	public Contatos consultar(Contatos contatoConsultar){
		
		Iterator<Contatos> it = this.getListaContatos().iterator();
		
		while(it.hasNext()){
			
			Contatos pessoa = (Contatos) it.next();
			
			if(pessoa.comparaTelefone(contatoConsultar.getTelefone())){
				return pessoa;
			}
				
		}
		return null;
		
	}
	
}
