<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Home Page</title>
    <style>
        /* Reset some default styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        /* Style the container */
        .container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
        }

        /* Style buttons */
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

        /* Add hover effect for buttons */
        button:hover {
            background-color: #0056b3;
        }

        /* Center text elements */
        h1, p {
            margin: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Your Hotel Dashboard</h1>
        <h3>${pos}</h3><h2>${neg}</h2>
        <a href="/hotel/add-item"><button>Add Item</button></a>
        <a href="/hotel/fetch-items"><button>Fetch Items</button></a>
        <a href="/logout"><button>Logout</button></a>
    </div>
</body>
</html>
