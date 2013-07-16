package agendaContatos;

public class Contatos {
	
	private String nome;
	private String telefone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Boolean comparaTelefone(String consultaTel){
		if (consultaTel.equalsIgnoreCase(this.telefone)){
			return true;
		}
		return false;
	}
	
	public boolean equals(Object a){
		Contatos pessoa = (Contatos) a;
		
		if(this.telefone.equalsIgnoreCase(pessoa.getTelefone())){
			return true;
		}
		
		return false;
	}
}
