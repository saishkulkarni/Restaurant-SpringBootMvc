<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Home</title>
    <style>
        /* Reset some default styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding: 0;
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
    </style>
</head>
<body>
${neg}${pos}
    <h1>Welcome to Our Restaurant</h1>
    <div>
        <a href="/customer/fetch-items"><button>View Menu</button></a>
        
        <a href="/customer/fetch-orders"><button>View Orders</button></a>
     <a href="/logout"><button>Logout</button></a>
    </div>
</body>
</html>
