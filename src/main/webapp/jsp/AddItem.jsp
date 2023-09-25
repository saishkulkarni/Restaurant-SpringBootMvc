<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Item</title>
</head>

<body>
    <form action="/hotel/add-item" method="post" enctype="multipart/form-data">
        Name: <input type="text" name="name" required><br>
        Price: <input type="text" name="price" required><br>
        Image: <input type="file" name="image" required><br>
        Stock: <input type="number" name="stock" required><br>
        Description: <input type="text" name="description" required><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Cancel">
    </form>
</body>

</html>