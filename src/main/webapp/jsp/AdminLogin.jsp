<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
        }

        /* Style form container */
        .form-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
        }

        /* Style form inputs */
        input[type="email"],
        input[type="password"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
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

        /* Add hover effect for buttons */
        button:hover {
            background-color: #0056b3;
        }

        /* Style register and back buttons */
        .btn-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
        }

        /* Center the form within the container */
        form {
            text-align: left;
        }

        /* Add space between links and buttons */
        a,
        button {
            margin-top: 10px;
        }
    </style>
</head>

<body>
	<div class="form-container">
        <form action="/admin/login" method="post">
            <h1>Login</h1>
            <label for="email">Email:</label>
            <input type="email" name="email" required/><br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" required/><br><br>
            <button>Login</button>
        </form>
        <div class="btn-container">
            <button type="reset">Cancel</button>
        </div>
    </div>
    <a href="/"><button>Back</button></a>
</body>

</html>