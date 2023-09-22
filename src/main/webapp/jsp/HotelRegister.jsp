<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="mvc"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    ${neg }
    <mvc:form action="/hotel/register" method="post" modelAttribute="hotel">
      <table border="1">
        <tr>
          <th>Name</th>
          <th><mvc:input path="name" /></th>
          <th><mvc:errors path="name" /></th>
        </tr>
        <tr>
          <th>Email</th>
          <th><mvc:input path="email" /></th>
          <th><mvc:errors path="email" /></th>
        </tr>
        <tr>
          <th>Password</th>
          <th><mvc:input path="password" /></th>
          <th><mvc:errors path="password" /></th>
        </tr>
        <tr>
          <th>Mobile</th>
          <th><mvc:input path="phone" /></th>
          <th><mvc:errors path="phone" /></th>
        </tr>
        <tr>
          <th><button type="submit">Signup</button></th>
          <th><button>Cancel</button></th>
        </tr>
      </table>
    </mvc:form>
  </body>
</html>
