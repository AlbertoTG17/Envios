<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	
		<h2>Añadir un paquete</h2>
		
		<form action="registrarPaquete">
			
			Fecha de entrega: <input type="date" name="fechaEntrega"/> <br>

				Tamaño: <select  name="medida">
						<option value="pequeño">Pequeño</option>
						<option value="mediano">Mediano</option>
						<option value="grande">Grande</option>			
					</select> <br>

			<label>Lugar de origen:</label> <input type="text" name="origen" id="origen"/> <br>

			<label>lugar de destino:</label> <input type="text" name="destino" id="destino"/> <br><br>
			
			<input type="submit" value="Entregar"/> 
		
		</form>
	
	</div>

</body>
</html>