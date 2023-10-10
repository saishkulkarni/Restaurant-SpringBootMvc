<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Home</title>
<style>
/* Reset some default styles */
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

/* Style the header */
h1 {
	color: #333;
	margin: 20px 0;
}

/* Style buttons */
button {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	margin: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

/* Add hover effect for buttons */
button:hover {
	background-color: #0056b3;
}

/* Style logout button and link */
a {
	text-decoration: none;
}

button.logout-button {
	background-color: #dc3545;
}

/* Center the buttons */
.button-container {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}
</style>
</head>
<body>
    <div class="button-container">
        <h1>Admin Home</h1>
        <a href="/admin/products"><button>Approve Products</button></a>
        <a href="/admin/hotels"><button>View Hotel</button></a>
       <a href="/admin/customers"><button>View Customers</button></a>
        <a href="/logout"><button class="logout-button">Logout</button></a>
    </div>
</body>
</html>
