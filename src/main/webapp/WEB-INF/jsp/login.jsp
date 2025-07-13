<html>
	<head>
		<title> Login Page </title>
	</head>
	<body>

	    <div>Welcome to the login page! - JSP</div>

        <div>${errorMessage}</div>

        <form method="post">
            Name : <input type="text" name="name">
            Password : <input type="password" name="password">
            <input type="submit">
        </form>
	</body>
</html>