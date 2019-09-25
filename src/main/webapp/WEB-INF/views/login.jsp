<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<title>Quan Ly Dao Tao</title>
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form name='loginForm'
			action="<c:url value='/login' />" method='POST'>
    <div class="form-group">
        <label for="text">Username:</label>
        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required/>
        
    </div>
    <div class="form-group">
        <label for="password">password</label>
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required/>
    </div>
    <div class="row">
    <button type="submit" class="button">Login</button>
    </div>
    </form>
</div>

</body>
</html>