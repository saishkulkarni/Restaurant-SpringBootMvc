<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" href="../css/login.css" />
  </head>
  <body>
    <h1 style="color: green">${pass}</h1>
    <h1 style="color: red">${fail}</h1>
    <form action="/admin/login" method="post">
      Email<input type="email" name="email" /><br /><br />
      Password<input type="password" name="password" /><br /><br />
      <a href=""><button>Login</button></a>
      <a href=""><button type="reset">Cancel</button></a>
    </form>
    <br />
    <a href="/"><button>Back</button></a>
  </body>
</html>
