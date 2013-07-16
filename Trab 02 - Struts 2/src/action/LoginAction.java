package action;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.User;

public class LoginAction extends ActionSupport implements SessionAware{
	
	private String userName;
	private String password;
	
	private Map<String,Object> session;

	private static final long serialVersionUID = 3501279472434952797L;
	
	private String verificarLogin(User u){
		User usuario = (User)session.get(u.getUserName());
		
		if(usuario!=null){
			if(u.getPassword().equalsIgnoreCase(usuario.getPassword())){
				session.put("logado", u);
				return SUCCESS;
			} 
		}
		addFieldError("invalid","Usu‡rio e/ou senha Errados");
		return INPUT;	
	}
	
	public String execute(){
		clearFieldErrors();
		User admin = new User("admin","admin");
		session.put("admin", admin);
		
		
		User u = new User(userName, password);
		return this.verificarLogin(u);
		
	}
	

	public String cadastra(){
		User u = new User(userName,password);
		if(!session.containsKey(u.getUserName())){
			session.put(this.userName, u);
			System.out.println("Cadastro Executado s— "+ this.userName);
			
		} else {
			addFieldError("invalid","Usu‡rio j‡ Cadastrado!");
			
		}
		
		
		Iterator<Entry<String, Object>> i = session.entrySet().iterator();
		while(i.hasNext()){
			String key = i.next().getKey();
			System.out.println(key+", "+ ((User)session.get(key)).getUserName());
		}
		return SUCCESS;
		
	}
		
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
		


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	

}
