<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pratProg_A04.Pais" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pais</title>
</head>
<body>
<%
	Pais pais = (Pais)request.getAttribute("pais");  
%>
<p>
ID: <%=pais.getId() %><br>
Nome: <%=pais.getNome() %><br>
Populacao: <%=pais.getPopulacao() %><br>
Area: <%=pais.getArea() %>
</p>
</body>
</html>