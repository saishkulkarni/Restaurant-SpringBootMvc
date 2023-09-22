<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding: 0;
            background-image:url("../images/2.jpg");
			background-size: cover;
        }

        h1 {
            color: green;
        }

        form {
            margin-top: 20px;
        }

        input[type="email"],
        input[type="password"] {
            width: 50%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
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

        button[type="reset"] {
            background-color: #dc3545;
        }

        button:hover {
            background-color: #0056b3;
        }

        a[href="/"] button {
            background-color: #333;
        }
    </style>
</head>
<body>
    <h1>${pass}</h1>
    <h1>${fail}</h1>
    <form action="/admin/login" method="post">
        <h1>Email</h1> <input type="email" name="email" required/><br /><br />
       <h1>Password</h1> <input type="password" name="password" required/><br /><br />
        <a href=""><button>Login</button></a> <a href=""><button type="reset">Cancel</button></a>
    </form><br />
    <a href="/"><button>Back</button></a>
</body>
</html>
