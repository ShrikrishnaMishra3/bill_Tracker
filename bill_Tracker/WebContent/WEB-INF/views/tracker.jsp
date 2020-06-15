<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bills Status Page</title>
</head>
<body>

<h3 align ="center" style="color:pink">Billes Information  </h3>
<table class="table table-striped"  border="1" padding="10">
 
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
                    <td><a href="editBill">Edit</a> / <a href="deletebill?id=${bill.id}">Delete</a></td>
             
                </tr>
            </c:forEach>
        </table>
</body>
</html>