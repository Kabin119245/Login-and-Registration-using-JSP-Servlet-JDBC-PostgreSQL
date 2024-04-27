<%
	if(session.getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Main Page</title>

	<style>
		body {
			font-family: Arial, sans-serif;
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
			margin: 0;
			background-color: #f4f4f4;
		}

		.loading-spinner {
			border: 8px solid rgba(0, 0, 0, 0.1);
			border-left-color: #1abc9c;
			border-radius: 50%;
			width: 50px;
			height: 50px;
			animation: spin 1s linear infinite;
		}

		@keyframes spin {
			to {
				transform: rotate(360deg);
			}
		}
	</style>

</head>
<body>
<h1>
	Hello World
</h1><br>

<div class="loading-spinner"></div>
</body>
</html>
