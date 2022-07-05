<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, inital-scale=1, shrink-to-fit=no">

<!-- BootStap CSS -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Customer Repository</title>

</head>
<body>
	<div class="container">
		<h3>Customer Repository</h3>
		<hr>
		<!-- Add a search form -->

		<!--  Add a button -->
		<a href="/com.greatlearning.crm/customer/showFormForAdd"
			class="btn btn-primary btn-sm mb-3">Add Customer</a>
		<table class="table -tablebordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>eMail</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
					
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.eMail}" /></td>
						<td><input type="hidden" name="id" value="${tempCustomer.id}" />

							<!-- Add "Update" button --> <a
							href="/com.greatlearning.crm/customer/showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm">Update</a> <!-- Add Delete button -->
							<a href="/com.greatlearning.crm/customer/deleteById?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if(!(confirm('Are you sure you want to delete this customer details?')))return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



</body>
</html>