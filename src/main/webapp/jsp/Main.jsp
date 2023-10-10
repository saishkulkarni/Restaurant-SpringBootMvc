<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

<style>
  /* Reset some default styles */
  body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
  }

  /* Header styling */
  h1 {
    text-align: center;
    color: #333;
    padding: 20px;
  }

  /* Center-align buttons horizontally */
  .button-container {
    text-align: center;
  }

  /* Button styling */
  .button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    margin: 10px;
    transition: background-color 0.3s ease;
  }

  .button:hover {
    background-color: #0056b3;
  }
</style>

</head>
<body>
<h3>${pos}</h3><h2>${neg}</h2>
<h1>My Restaurant</h1>

<div class="button-container">
  <a href="/admin" class="button">Admin</a>
  <a href="/hotel" class="button">Hotel</a>
  <a href="/customer" class="button">Customer</a>
</div>

</body>
</html>
