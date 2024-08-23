<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page - Add Doctor</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:#1c7430;
            margin: 0;
            padding: 0;
        }
        

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"], input[type="time"], input[type="file"] {
            width: 80%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        /* Center the button container */
.containerbtn {
    display: flex;
    justify-content: center; /* Centers the button horizontally */
    align-items: center; /* Centers the button vertically if needed */
}

button {
    display: inline-block;
    background-color: #28a745;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 50%;
    text-align: center;
}

        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Add Doctor</h2>
        <p>This is the Admin Page.</p>
        <pre>
        
        Rule For Admin.
        
        1. Add only 1:1 picture for the perfect user interface.
        2. Check the information before click the submit button.
        3. This page is only to add the Doctor's information 
        so follow the instructions.
        
        
        
        </pre>
        <form action="SubmitData" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="doctorName">Doctor Name</label>
                <input type="text" id="doctorName" name="doctorName" placeholder="Enter doctor's name" required>
            </div>

            <div class="form-group">
                <label for="bachelor">Bachelor</label>
                <input type="text" id="bachelor" name="bachelor" placeholder="Enter qualification" required>
            </div>

            <div class="form-group">
                <label for="time">Arriving Time</label>
                <input type="time" id="time" name="time" required>
            </div>
            
            <div class="form-group">
                <label for="time">Depart Time</label>
                <input type="time" id="time" name="time" required>
            </div>

            <div class="form-group">
                <label for="image">Upload Image</label>
                <input type="file" id="image" name="image" accept="image/*">
            </div>
            <br><br>
            <div class="containerbtn">
            <button type="submit">Submit</button><br><br>
            </div>
        </form>
    </div>

</body>
</html>
