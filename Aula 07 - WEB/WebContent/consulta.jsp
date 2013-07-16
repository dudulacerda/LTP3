<%@page import="java.util.*"%>
<%@page import="agendaContatos.*"%>
<%@page import="sistemaLogin.*"%>

<% if(session.getAttribute("login")==null){
		request.setAttribute("msg","Sessão Expirada!");
		pageContext.forward("login.jsp");
	}else{
		Login login = (Login)session.getAttribute("login");
		out.print("Bem Vindo: "+login.getNome());
	}
%>

<h1>Consultar Telefone</h1>

<%
	GerenciaContatos gc = (GerenciaContatos) application.getAttribute("gerenciaContatos");
%>

<form name="formConsulta" method="get"action= "consulta.jsp">
	<p>
		Telefone:
		<input type="text" name="telefone">
		<br>
		<input type="submit" name="consulta" value="Consultar">
	</p>
</form>		



<%
	if(!(request.getParameter("consulta")==null)){
		
		Contatos consultaContato = new Contatos();

		consultaContato.setTelefone(request.getParameter("telefone"));
		
		Contatos pessoa = gc.consultar(consultaContato); 
		
		if(pessoa!=null){
			out.println("<TR><TD>"+"Nome: "+pessoa.getNome()+" </TD><TD>"+"Telefone: "+pessoa.getTelefone()+"</TD></TR>");
		}else{
			out.println("Telefone não existe");
		}	
	}
%>
<br>
<br>
<a href="agenda.jsp">Agenda de Contatos</a>
<br>
<a href="index.jsp">Home</a>
