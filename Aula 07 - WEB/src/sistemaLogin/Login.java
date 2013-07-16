package sistemaLogin;

public class Login {
	
	private String nome;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
	public boolean equals(Object a){
		Login l = (Login) a;
		
		if(this.nome.equalsIgnoreCase(l.getNome())){
			return true;
		}
		
		return false;
	}
}
