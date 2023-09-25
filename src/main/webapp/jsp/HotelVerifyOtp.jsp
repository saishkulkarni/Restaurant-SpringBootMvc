<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    ${pos} ${neg}
    <form action="/hotel/verify-otp" method="post">
      <h1>Enter Otp</h1>
      <input type="text" name="id" value="${id}" hidden="hidden" /><br />
      <br />
      <br /><input type="text" name="otp" /><br />
      <a href=""><button>Submit</button></a>
      <button type="reset">Cancel</button>
    </form>
  </body>
</html>
