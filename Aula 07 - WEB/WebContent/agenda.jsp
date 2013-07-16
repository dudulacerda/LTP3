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


<%
	GerenciaContatos gc = (GerenciaContatos) application.getAttribute("gerenciaContatos");
	if(gc == null){
		gc = new GerenciaContatos();
		application.setAttribute("gerenciaContatos",gc);   //Seta a varivael para Aplicaçao
	}
%>
<br>
<h1>Agenda de Telefone</h1>

<%
	if(!(request.getParameter("grava")==null)){
		Contatos pessoa = new Contatos();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setTelefone(request.getParameter("telefone"));
		
		if(!(gc.addContato(pessoa))){
			out.println("Telefone já existe");
		}
			
	}
%>

<form name="formAgenda" method="get"action= "agenda.jsp">
	<p>Nome:
		<input type="text" name="nome">
		<br>
		Telefone:
		<input type="text" name="telefone">
		<br>
		<input type="submit" name="grava" value="salvar">
	</p>
</form>		

<a href="consulta.jsp">Consultar Telefone</a>
<br>
<br>

<TABLE BORDER="4px">
<TR><TH>Nome</TH><TH>Telefone</TH></TR>

<%
	Iterator it = gc.getListaContatos().iterator();
	while(it.hasNext()){
		Contatos pessoa = (Contatos) it.next();
		out.println("<TR><TD>"+pessoa.getNome()+"</TD><TD>"+pessoa.getTelefone()+"</TD</TR>");
	}
%>
</TABLE>