<%--
  Created by IntelliJ IDEA.
  User: Kabin Giri
  Date: 4/28/2024
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Videos Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .video-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .logout-button {
            display: block;
            width: 100px;
            margin: 20px auto;
            padding: 10px;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
        }

        .logout-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>

<div class="container">
    <h1>Videos</h1>
    <div class="video-container">
        <iframe width="560" height="315" src="https://www.youtube.com/embed/rul5rbvbaF8?si=QAbai_c-nXUDO4U7"
                title="YouTube video player" frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
    </div>
    <form action="LogoutServlet">
        <button class="logout-button" type="submit">Logout</button>
    </form>
</div>
</body>
</html>

