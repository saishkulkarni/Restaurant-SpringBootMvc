<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Item name</td>  
            <td>Picture</td>
            <td>Price</td>
            <td>Stock</td>
            <td>Description</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
<c:forEach var="item" items="${items}">
    <tr>
        <td>${item.getName()}</td>  
        <td>

        </td>
        <td>${item.getPrice()}</td>
        <td>
            ${item.getStock()}
        </td>
        <td>${item.getDescription()}</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
</c:forEach>
    </table>
</body>
</html>