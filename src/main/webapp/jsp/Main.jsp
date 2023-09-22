<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	text-align: center;
	margin: 0;
	padding: 0;
	background-image:url("../images/1.jpg");
	background-size: cover;
}

button {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	margin: 10px;
	border: none;
	cursor: pointer;
	font-size: 16px;
	border-radius: 5px;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<a href="/admin"><button>Admin</button></a>
	<a href="/hotel"><button>Hotel</button></a>
	<a href="/customer"><button>Customer</button></a>
</body>
</html>
