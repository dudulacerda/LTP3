<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login App</title>
<s:head/>
</head>
<body>
	<s:div>
		<h3>Bem Vindo <s:property value="#session['logado'].userName"/> ao Cadastro de Usuários</h3><br/>
		
		<s:fielderror name="invalid"/>
		<s:form action="CadastraAction" validate="true" method="post" namespace="action">
			<s:textfield name="userName" required="true" label="Login"/>
			<s:password name="password" required="true" label="Senha"/>
			<s:submit/>
		
		</s:form>
		
		<TABLE BORDER="4px">
		<TR><TH>Login</TH><TH>Senha</TH></TR>
		
		<s:iterator value="#session" var="key">
			<s:if test="key != 'logado'"> 
				<TR><TD><s:property value="#session[key].userName" /></TD><TD><s:property value="#session[key].password"/></TD></TR>
			</s:if>
		</s:iterator>

		</TABLE>
		
		<br/>
		<a href="login">Voltar</a>
		
	</s:div>
</body>
</html>