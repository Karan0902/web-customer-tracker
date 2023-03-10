<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Save Customer</title>
		
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath }/resources/css/style.css">
				
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath }/resources/css/add-customer-style.css">
	</head>
		
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Save Customer</h3>
			
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
				<!-- need to assiciate this data with customer id -->
				<form:hidden path="id"></form:hidden>
				
				<table>
					<tbody>
					
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName"></form:input></td>
						</tr>
						
						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName"></form:input></td>
						</tr>
						
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email"></form:input></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"></input></td>
						</tr>
						
					</tbody>
				</table>
			</form:form>
			
			
			<!-- back to list -->
			<div style="clear; both;">
				<p>
					<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
				</p>
			</div>
		</div>
	</body>
</html>