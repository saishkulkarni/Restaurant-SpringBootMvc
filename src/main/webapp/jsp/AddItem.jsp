<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Item</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #e74c3c;
            margin-top: 20px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="number"],
        input[type="file"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        fieldset {
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        legend {
            font-weight: bold;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            background-color: #e74c3c;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #c0392b;
        }
    </style>
</head>

<body>
    <h1>Add Item</h1>
    <div class="container">
        <form action="/hotel/add-item" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Item Details</legend>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="price">Price:</label>
                <input type="number" id="price" name="price" required>

                <label for="image">Image:</label>
                <input type="file" id="image" name="image" required>

                <label for="stock">Stock:</label>
                <input type="number" id="stock" name="stock" required>

                <label for="description">Description:</label>
                <input type="text" id="description" name="description" required>
            </fieldset>

            <input type="submit" value="Add">
            <input type="reset" value="Cancel">
        </form>
    </div>
    <br>
    <a href="/hotel/home"><button>Back</button></a>
</body>

</html>
