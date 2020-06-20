<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<form role="form" class="col-md-9 go-right" action="addBills">
				<h2>Add a New Bill</h2>

				<div class="form-group">
					<label for="name">Title</label> <input id="name" name="billTitle"
						type="text" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="name">Category</label> <input id="name" name="category"
						type="text" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="name">Amount</label> <input id="name" name="amount"
						type="text" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="dateOfEntry">DateOfEntry</label> <input type="date"
						id="dateOfEntry" name="dateOfEntry"  class="form-control" required>
				</div>
				<div class="form-group">
					<label for="dueDate">DueDate</label> <input id="date"
						name="dueDate" type="date" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="name">Paid</label> <input id="name" name="paid"
						type="text" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="name">Unpaid</label> <input id="name" name="unpaid"
						type="text" class="form-control" required>
				</div>
		</div>
		<br>
		<div class="form-group">
			<div align="left">
				<button type="submit" class="btn btn-primary">Add or Update</button></div>
			</div>
			</form>
		</div>
		
	</div>

</body>
</html>