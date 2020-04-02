<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pratProg_A04.Pais, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Paises</title>
</head>
<body>
<%
	ArrayList<Pais> pais = (ArrayList<Pais>)request.getAttribute("paises");
	for(Pais paises:pais){
%>
<p>
<label>ID:</label> <%=paises.getId() %><br>
<label>Nome:</label> <%=paises.getNome() %><br>
<label>Populacao:</label> <%=0+paises.getPopulacao() %><br>
<label>Area:</label> <%=0+paises.getArea() %>
</p>
<%} %>
</body>
</html>