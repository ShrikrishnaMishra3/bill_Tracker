<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Bill</h1>
		<form:form action="updateBill" method="post" modelAttribute="bill">
			<table>
				<tr>

					<td><form:hidden path="id" /></td>
				</tr>
				<tr>
					<td>Title:</td>
					<td><form:input path="billTitle" id="billTitle" /></td>
				</tr>

				<tr>
					<td>Category:</td>
					<td><form:input path="category" id="category" /></td>
				</tr>
				<tr>
					<td>Amount:</td>
					<td><form:input path="amount" id="amount" /></td>
				</tr>

				<tr>
					<td>DateOfEntry:</td>
					<td><form:input path="dateOfEntry" id="dateOfEntry" /></td>
				</tr>
				<tr>
					<td>DueDate:</td>
					<td><form:input path="dueDate" id="dueDate" /></td>
				</tr>
				<tr>
					<td>Paid:</td>
					<td><form:input path="paid" id="paid" /></td>
				</tr>
				<tr>
					<td>Unpaid:</td>
					<td><form:input path="unpaid" id="unpaid" /></td>
				</tr>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>