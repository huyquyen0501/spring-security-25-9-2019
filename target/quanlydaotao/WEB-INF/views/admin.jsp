<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<style type="text/css">
/*==Reset CSS==*/
* {
  margin: 0;
  padding: 0;
}

/*==Style cơ bản cho website==*/
body {
  font-family: sans-serif;
  color: #333;
}

/*==Style cho menu===*/
#menu ul {
  background: #1F568B;
  list-style-type: none;
  text-align: center;
}
#menu li {
  color: #f1f1f1;
  display: inline-block;
  width: 15%;
  height: 40px;
  line-height: 40px;
  margin-left: -5px;
}
#menu a {
  text-decoration: none;
  color: #fff;
  display: block;
}
#menu a:hover {
  background: #F1F1F1;
  color: #333;
}


</style>
</head>
<body>
	<div id="menu">
  <ul>
  	<li><a href="admin">Home admin</a></li>
    <li><a href="admin/getAll">Danh sach nguoi dung</a></li>
    <li><a href="admin/findbyName">Tim nguoi dung</a></li>
    <li><a href="admin/addrole">Chinh sua quyen nguoi dung</a></li>
    <li><a href="admin/deactive">Vo hieu hoa nguoi dung </a></li>
    <li><a href="admin/delete">Xoa nguoi dung</a></li>
  </ul>
</div>
	
	
	<a href="javascript:formSubmit()"> Logout</a>
	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>



</body>
</html>