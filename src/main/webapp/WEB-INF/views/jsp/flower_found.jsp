<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>

<div style="font-weight: bold">Flower found:</div>		
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Freshness</td>
			<td>Price</td>
			<td>Spike</td>
			<td>Bouquet Id</td>
		</tr>
		
		<%-- <c:forEach items="${listFlowers}" var="flower"> --%>		
		<tr>
			<td>${flower.id}</td>
			<td>${flower.name}</td>
			<td>${flower.freshness.freshness}</td>
			<td>${flower.price}</td>
			<td>${flower.spike}</td>
			<td>${flower.bouquetId}</td>
		</tr>		
		<%-- </c:forEach> --%>
		
		
	</table>

</body>
</html>