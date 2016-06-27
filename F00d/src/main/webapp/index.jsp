<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restauration Express</title>
</head>
<body>
	<label>Choisissez un restaurant : </label>
	<form action="commande" method="POST">
		<select name="idRest">
			<c:forEach items="${restaurants}" var="restaurant">
				<option value="${restaurant.idRest}">
					${restaurant.getNom()}, ${restaurant.getAddressL1()},
					${restaurant.getCodePostal()}</option>
			</c:forEach>
		</select> <input type="hidden" name="idUti" value="1"> <input
			type="submit" value="Suivant" />
	</form>

</body>
</html>