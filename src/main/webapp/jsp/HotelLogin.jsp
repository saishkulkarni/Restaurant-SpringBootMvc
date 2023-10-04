<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .container {
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            max-width: 400px;
            margin: 0 auto;
        }

        .container h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        form {
            text-align: left;
        }

        label {
            display: block;
            font-weight: bold;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-right: 10px;
        }

        a {
            text-decoration: none;
        }

        a button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            text-decoration: none;
            display: inline-block;
        }

        button[type="reset"] {
            background-color: #ccc;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
    <h3>${pos}</h3><h2>${neg}</h2>
        <h1>Login</h1>
        <form action="/hotel/login" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required /><br /><br />

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required /><br /><br />

            <button type="submit">Login</button>
            <button type="reset">Cancel</button><br /><br />
        </form>
        <a href="/hotel/register"><button>Register</button></a><br /><br />
        <a href="/"><button>Back</button></a>
    </div>
</body>
</html>
