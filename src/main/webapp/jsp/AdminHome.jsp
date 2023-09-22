<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin Home</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: #f0f0f0;
}

h1 {
	color: #333;
}

button {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	margin: 10px;
	border: none;
	cursor: pointer;
}

a {
	text-decoration: none;
}

a button.logout-button {
	background-color: #dc3545;
}
</style>
</head>
<body>
	<h1>Admin Home</h1>
	<button>Approve Products</button>
	<button>View Hotel</button>
	<button>View Customers</button>
	<a href="/logout"><button class="logout-button">Logout</button></a>
</body>
</html>
