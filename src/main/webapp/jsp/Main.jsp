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
    background-color: #f4f4f4;
    text-align: center;
    margin: 0;
    padding: 0;
}

.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
}

.button-container {
    display: flex;
    flex-direction: column;
    margin-top: 20px;
}

.button-container a {
    text-decoration: none;
    margin: 10px 0;
}

.button {
    background-color: #007bff;
    color: #fff;
    padding: 12px 24px;
    border: none;
    cursor: pointer;
    font-size: 18px;
    border-radius: 5px;
    text-decoration: none;
    transition: background-color 0.3s ease;
    display: inline-block;
}

.button:hover {
    background-color: #0056b3;
}

.logo {
    font-size: 36px;
    font-weight: bold;
    color: #333;
    margin-bottom: 20px;
}

</style>
</head>
<body>
<h3>${pos}</h3><h2>${neg}</h2>
    <div class="container">
        <div class="logo">My Restaurant</div>
        <div class="button-container">
            <a href="/admin" class="button">Admin</a>
            <a href="/hotel" class="button">Hotel</a>
            <a href="/customer" class="button">Customer</a>
        </div>
    </div>
</body>
</html>