<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        /* Reset some default styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding: 0;
            background-image: url("../images/2.jpg");
            background-size: cover;
        }

        /* Style the header */
        h1 {
            color: green;
        }

        /* Style the form */
        form {
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        /* Style form inputs */
        input[type="email"],
        input[type="password"] {
            width: 50%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
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

        /* Style reset button */
        button[type="reset"] {
            background-color: #dc3545;
        }

        /* Add hover effect for buttons */
        button:hover {
            background-color: #0056b3;
        }

        /* Style back button */
        a[href="/"] button {
            background-color: #333;
        }

        /* Center the text elements */
        h1, a {
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <form action="/admin/login" method="post">
        <h1>Email</h1>
        <input type="email" name="email" required /><br /><br />
        <h1>Password</h1>
        <input type="password" name="password" required /><br /><br />
        <button type="submit">Login</button>
        <button type="reset">Cancel</button>
    </form><br />
    <a href="/"><button>Back</button></a>
</body>

</html>
