<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Bills Status Page</title>
</head>
<body>

<h3 align ="center" style="color:black"> Tracker  </h3><br><br><br>


<a class="btn btn-secondary btn-lg btn-block" href="addBill">Add Bill</a><br><br><br>

<table class="table table-sm table-dark"  border="1" padding="10">
 
          	<th>BillTitle</th>
		<th>Category</th>
		<th>Amount</th>
		<th>DateOfEntry</th>
		<th>DueDate</th>
		<th>Paid</th>
		<th>Unpaid</th>
		<th>Action</th>
		<c:forEach var="bill" items="${billes}">
			<tr>
				<td>${bill.billTitle}</td>
				<td>${bill.category}</td>
				<td>${bill.amount}</td>
				<td>${bill.dateOfEntry}</td>
				<td>${bill.dueDate}</td>
				<td>${bill.paid}</td>
				<td>${bill.unpaid}</td>
                    <td><a href="editBill?id=${bill.id}">Edit</a> / <a href="deletebill?id=${bill.id}">Delete</a></td>
             
                </tr>
            </c:forEach>
        </table>
</body>
</html>