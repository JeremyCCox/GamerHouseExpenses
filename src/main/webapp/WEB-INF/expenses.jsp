<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Filing</title>
</head>
<body>
	<form action="UpdateForm" method="POST">
	How many payees are being calculated?
		<input name="peopleQuantity" type="number" onChange="this.form.submit()" value="${perPerson}" min="0">
	</form>
	<c:if test="${perPerson != null}">
		<form action="CalculateExpences" method="POST">
			<input name="peopleQuantity" type="number" value="${perPerson}" hidden="TRUE">
			<table>
				<tr><td>Person</td><td>Rent</td><td>Utilities</td><td>Expenses</td></tr>
				<c:forEach var="count" begin="1" end="${perPerson}">
					<c:out escapeXml="false" value="<tr><td><input required='true' name='person${count}'type='text' placeholder='person${count}'></td><td><input name='rent${count}' type='checkbox'></td><td><input name='utils${count}' type='checkbox'> </td><td><input name='expenses${count}' type='checkbox'> </td></tr>"></c:out>
				</c:forEach>
			</table>
			<label>Rent Total </label>
			<input type="number" name="totalRent" >
			<label>Utilities Total </label>
			<input type="number" name="totalUtils" >
			<label>Expenses Total </label>
			<input type="number" name="totalExpenses" >
			<input type="submit" value="Enter">
		</form>
	</c:if>
</body>
</html>