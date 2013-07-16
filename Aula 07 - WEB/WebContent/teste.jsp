<%@ page import="teste.AloMundo"%>

<H1>Testando</H1>

<% 
	AloMundo alo = new AloMundo(); 
	out.println("Alo");
%>

<body>
	<%= alo.getAlo() %> 
</body>