<%@ page import="java.util.List" %>
<%@ page import="com.example.DoctorDetails" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Details Gallery</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        .header {
            padding: 20px;
            text-align: center;
            background: #333;
            color: #fff;
        }
        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;
            padding: 20px;
        }
        .image-item {
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            overflow: hidden;
            text-align: center;
            transition: transform 0.3s ease;
        }
        .image-item:hover {
            transform: scale(1.05);
        }
        .image-item img {
            width: 100%;
            height: auto;
            display: block;
        }
        .caption {
            padding: 10px;
            background: #f9f9f9;
            border-top: 1px solid #ddd;
        }
        .caption p {
            margin: 0;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Information of Doctors</h1>
        <p>Every Monday to Saturday, the doctors takes their regular time for each day.</p><br>
        <p>Select the doctor that will suit or convenient for you.</p>
    </div>
    <div class="container">
        <div class="grid">
            <%
                List<DoctorDetails> doctorList = (List<DoctorDetails>) session.getAttribute("doctorList");
                if (doctorList != null) {
                    for (DoctorDetails doctorDetails : doctorList) {
                        out.print("<div class='image-item'>");
                        out.print("<img src='uploads/" + doctorDetails.getImageFileName() + "' alt='Doctor Image'>");
                        out.print("<div class='caption'>");
                        out.print("<p><strong>Doctor Name:</strong> " + doctorDetails.getDoctorName() + "</p>");
                        out.print("<p><strong>Bachelor:</strong> " + doctorDetails.getBachelor() + "</p>");
                        out.print("<p><strong>Time:</strong> " + doctorDetails.getTime() + "</p>");
                        out.print("</div>");
                        out.print("</div>");
                    }
                } else {
                    out.print("<p>No doctor details found.</p>");
                }
            %>
        </div>
    </div>
</body>
</html>
