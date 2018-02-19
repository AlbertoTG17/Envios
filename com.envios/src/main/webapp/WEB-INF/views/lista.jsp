<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	
		<table border="1">
		
			<c:forEach items="${listaPaquetes}" var="paq">
			
				<tr>
					<td>${paq.tamaño}</td>
					<td>${paq.origen}</td>
					<td>${paq.destino}</td>
					<td><a href="mapa.jsp?origen=${paq.origen}&destino=${paq.destino}">Ver ruta</a></td>
				</tr>
			
			</c:forEach>
		
		
		</table>
		
		<input type="hidden" name="origen" value="${paq.origen}">
		<input type="hidden" name="destino" value="${paq.destino}">
	
	</div>

</body>
</html>