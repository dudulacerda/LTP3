<%@page import="java.util.*"%>
<%@page import="sistemaLogin.*"%>

<%
	GerenciaLogin gl = (GerenciaLogin) application.getAttribute("gerenciaLogin");
	if(gl == null){
		gl = new GerenciaLogin();
		application.setAttribute("gerenciaLogin",gl);   //Seta a varivael para Aplicaao
	}
	
	
%>

<%
	if(request.getParameter("Submit")!=null){
		Login l = new Login();
		l.setNome(request.getParameter("nome"));
		l.setSenha(request.getParameter("senha"));
		
		if(gl.verificar(l)){
			out.println("Login efetuado com Sucesso");
			session.setAttribute("login",l);
			session.setMaxInactiveInterval(100);
			
		}else{
			request.setAttribute("msg","Login Inválido");
			pageContext.forward("login.jsp");
		}
	} else if(session.getAttribute("login")==null){
		request.setAttribute("msg","Sessão Expirada!");
		pageContext.forward("login.jsp");
		}else{
			Login login = (Login)session.getAttribute("login");
			out.println("<br>");
			out.println("<br>");
			out.println("Bem Vindo: "+login.getNome());
		}
%>

<h1><b>Cadastro de Login</b></h1>

<%
	if(!(request.getParameter("grava")==null)){
		Login l = new Login();
		l.setNome(request.getParameter("nome"));
		l.setSenha(request.getParameter("senha"));
		
		if(!gl.add(l)){
			out.println("Login ja existe");
		}
			
	}
%>
	
	
	

<form name="form1" method="get"action= "index.jsp">
	<p>Login:
		<input type="text" name="nome">
		<br>
		Senha:
		<input type="text" name="senha">
		<br>
		<input type="submit" name="grava" value="salvar">
	</p>
</form>		

<a href="agenda.jsp">Agenda de Contatos</a>
<br>
<br>
<br>


<TABLE BORDER="4px">
<TR><TH>Login</TH><TH>Senha</TH></TR>

<%
	Iterator it = gl.getListaLogin().iterator();
	while(it.hasNext()){
		Login l = (Login) it.next();
		out.println("<TR><TD>"+l.getNome()+"</TD><TD>"+l.getSenha()+"</TD</TR>");
	}
%>
</TABLE>

