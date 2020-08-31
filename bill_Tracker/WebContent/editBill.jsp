<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Edit Bills</title>
</head>
<body>


<form action="updateBill">
<c:set var="bill" value="${bill }" />
<h3 align=center>Billes App Management System </h2>
<table class="table table-striped">
<tr>  <td>BillTitle </td><td><input type="text" name="title"  value= "${bill.billTitle }" /></td></tr>
<tr><td>Category</td><td> <input type="text" name="category" value= "${bill.category}"   /></td></tr>
<tr><td>Amount</td><td> <input type="int" name="amount"  value="${bill.amount}" /><br></td></tr>
<tr><td>DateOfEntry</td><td> <input type="date" name="dateOfEntry"  value="${bill.dateOfEntry}" /><br></td></tr>
<tr><td>DueDate</td><td> <input type="date" name="dueDate"  value="${bill.dueDate}" /><br></td></tr>
<tr><td>Paid</td><td> <input type="text" name="paid"  value="${bill.paid}" /><br></td></tr>
<tr><td>Unpaid</td><td> <input type="text" name="unpaid"  value="${bill.unpaid}" /><br></td></tr>
<div align="center"></div><tr colspan=2><td><input type="submit" value="Update" /></td></tr></div>
</table>
</form>
</body>
</html>