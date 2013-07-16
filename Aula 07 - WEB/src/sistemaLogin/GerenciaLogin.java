package sistemaLogin;

import java.util.ArrayList;
import java.util.List;

public class GerenciaLogin {
	
	private List<Login> listaLogin = new ArrayList<Login>();	//Cria uma lista que armazena os logins

	public GerenciaLogin(){										//No construtor j‡ Ž criado um login, para que possamos acessar
		Login admin = new Login();
		admin.setNome("admin");
		admin.setSenha("ltp3");
		
		this.listaLogin.add(admin);								// Armazena o login padrao na listaLogin
	}
	
	public boolean add(Login l){								
		if(!this.listaLogin.contains(l)){						//Verifica se o login ja esta presente na listaLogin
			this.listaLogin.add(l);
			return true;
		}
		return false;
	}
	
	public boolean verificar(Login l){
		
		int index = this.listaLogin.indexOf(l);				//Verifica se o login l esta na lista e retorna a posiao
		
		if(index >= 0){
			Login loginL = this.listaLogin.get(index);		//Pega o elemento da posicao 
			
			if(loginL.getSenha().equals(l.getSenha())){		//Verifica a senha do login recuperado com a senha do paramentro
				return true;
			}
		}
		
		return false;
	}
	
	public List<Login> getListaLogin(){
		return this.listaLogin;
	}
	
}
