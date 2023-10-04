<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
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

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            margin-bottom: 20px;
        }

        th {
            text-align: left;
        }

        .form-input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        .error-message {
            color: #ff0000;
            font-size: 14px;
        }

        .button-container {
            margin-top: 20px;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration</h1>
        ${neg}
        <mvc:form action="/hotel/register" method="post" modelAttribute="hotel">
            <table>
                <tr>
                    <th><label for="name">Name:</label></th>
                    <th><mvc:input path="name" id="name" class="form-input" /></th>
                    <th><div class="error-message"><mvc:errors path="name" /></div></th>
                </tr>
                <tr>
                    <th><label for="email">Email:</label></th>
                    <th><mvc:input path="email" id="email" class="form-input" /></th>
                    <th><div class="error-message"><mvc:errors path="email" /></div></th>
                </tr>
                <tr>
                    <th><label for="password">Password:</label></th>
                    <th><mvc:input path="password" id="password" class="form-input" /></th>
                    <th><div class="error-message"><mvc:errors path="password" /></div></th>
                </tr>
                <tr>
                    <th><label for="phone">Mobile:</label></th>
                    <th><mvc:input path="phone" id="phone" class="form-input" /></th>
                    <th><div class="error-message"><mvc:errors path="phone" /></div></th>
                </tr>
                <tr>
                    <th class="button-container">
                        <button type="submit">Signup</button>
                        <button type="reset">Cancel</button>
                    </th>
                </tr>
            </table>
        </mvc:form>
        <br>
        <a href="/hotel"><button>Back</button></a>
    </div>
</body>
</html>
