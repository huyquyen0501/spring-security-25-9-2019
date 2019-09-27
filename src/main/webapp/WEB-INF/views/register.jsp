<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<title>Quan Ly Dao Tao</title>
</head>
<body>
	<div class="container">
		<h2>Register</h2>
		<form action="register" name="register" method="post">
			<div class="form-group">
				<label for="text">name:</label> <input type="text"
					class="form-control" id="name" placeholder="name" name="name"
					required />

			</div>
			<div class="form-group">
				<label for="text">address</label> <input type=text
					class="form-control" id="address" placeholder="Enter address"
					name="address" required />
			</div>
			<div class="form-group">
				<label for="text">username</label> <input type=text
					class="form-control" id="username" placeholder="Enter username"
					name="username" required />
			</div>
			<div class="form-group">
				<label for="text">password</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password" required />
			</div>
			<div>
				<label for="text">Gioi tinh</label>
				<input type = "text" class="form-control" id="sex" placeholder="Nam/Nu" name="sex" required="required"/>

			</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<div class="row">
		<button type="submit" class="button">Register</button>
	</div>
	</form>
	</div>
	<script type="text/javascript">
		$("input:checkbox").click(function() {
			var bol = $("input:checkbox:checked").length >= 1;
			$("input:checkbox").not(":checked").attr("disabled", bol);
		});
	</script>
</body>
</html>