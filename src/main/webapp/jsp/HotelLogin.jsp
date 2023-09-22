<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <body>
    ${pos} ${neg}
    <form action="/hotel/login" method="post">
      Email: <input type="email" name="email" required /><br />
      <br />
      Password: <input type="password" name="password" required/><br />
      <br />
      <button>Login</button>
      <button type="reset">Cancel</button>
      <br />
      <br />
    </form>
    <a href="/hotel/register"><button>Register</button></a>
    <br><br>
    <a href="/"><button>Back</button></a>
  </body>
</html>
