<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restauration Express : ${restaurant.getNom()}</title>
</head>
<body>
	<label>Choisissez un Categorie : </label>
	<div>
		<form action="Add" method="POST">
			<select name="idElem">
				<c:forEach items="${elements}" var="element">
					<option value="${element.idElem}">${element.libelle}:
						${element.prix} E</option>
				</c:forEach>
				<input type="hidden" name="idUti" value="1">
				<input type="hidden" name="idRest" value="${restaurant.getIdRest()}">
				<input type="submit" value="Add" />
			</select>
	</div>
	</form>
	<div>
		<table>
			<tr>
				<th>Plat</th>
				<th>Categorie</th>
				<th>Prix</th>
			</tr>

			<c:forEach items="${commandes}" var="commande">
				<form action="supp" method="POST">
				<tr>
					<td>${commande.element.libelle}</td>
					<td>${commande.element.categorie.getNom()}</td>
					<td>${commande.element.prix}</td>
					<input type="hidden" name="idUti" value="${commande.getUtilisateur().getIdUti()}">
					<input type="hidden" name="idCom" value="${commande.getIdCom()}">
					<input type="hidden" name="idRest"
						value="${restaurant.getIdRest()}">
					<td><input type="submit" name="${commande.getIdCom()}"
						value="X" /></td>
				</tr>
				</form>
			</c:forEach>

			<tr>
				<td colspan="2">Total :</td>
				<td>   <!--  A calculer  --></td>

			</tr>
		</table>
	</div>
	<form action="paiement" method="POST">
		<input type="hidden" name="idRest" value="${restaurant.getIdRest()}">
		<input type="hidden" name="idUti" value="1">
		<input type="submit" value="Finaliser" />
	</form>



</body>
</html>