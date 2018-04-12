<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>

<p>All flowers have been updated</p>

<div style="font-weight: bold">Updated Bouquet Flower List:</div>		
	<table border="1" >
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Freshness</td>
			<td>Price</td>
			<td>Spike</td>
			<td>Bouquet Id</td>
		</tr>
		
		<c:forEach items="${listFlowersUpdated}" var="flower">		
			<tr>
				<td>${flower.id}</td>
				<td>${flower.name}</td>
				<td>${flower.freshness.freshness}</td>
				<td>${flower.price}</td>
				<td>${flower.spike}</td>
				<td>${flower.bouquetId}</td>
			</tr>		
		</c:forEach>
		
		
	</table>

</body>
</html>