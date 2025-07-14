<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Add Todo Page </title>

		<link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	</head>
	<body>
	<div class="container">
        <h1>Enter Todo Details</h1>
        <form method="post">
            Description: <input type="text" name="description" id="">
            <input type="submit" class="btn btn-success">
        </form>
    </div>
    <script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>