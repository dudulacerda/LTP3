package interceptor;

import java.util.Map;

import model.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class AuthenticationInterceptor implements Interceptor{

	private static final long serialVersionUID = 3139564631127887839L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		User user = (User)session.get("logado");
		if(user==null){
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}

}
