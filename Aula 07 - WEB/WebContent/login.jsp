<%
	if(!(request.getAttribute("msg")==null)){
		%>
		<%="Atencao:"+request.getAttribute("msg")%>
		<%
		} 
%>

<form name="form1" method="get" action="index.jsp">
	<p>Login:
		<input type="text" name="nome">
		<br>
		Senha:
		<input type="text" name="senha">
		<br>
		<input type="submit" name="Submit" value="OK">
	</p>
</form>	