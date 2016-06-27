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
	<table>
		<tr>
			<th>Plat</th>
			<th>Categorie</th>
			<th>Prix</th>
		</tr>

		<c:forEach items="${commandes}" var="commande">
			<tr>
				<td>${commande.element.libelle}</td>
				<td>${commande.element.categorie.getNom()}</td>
				<td>${commande.element.prix}</td>
			</tr>

		</c:forEach>

		<tr>
			<td colspan="2">Total :</td>
			<td>E</td>

		</tr>
	</table>





	<form action="final" method="POST">
		Indique le numero de carte : <input type="text" name="noCart" /><br/>
		Indique la date Expiration : <input type="datetime" name="dateExp" /><br/>
		Indique le cryptograme : <input type="text" name="crypt" /><br/>
		 <input type="hidden" name="idUti" value="1">
		 <input type="submit" value="Finaliser" />
	</form>
</body>
</html>