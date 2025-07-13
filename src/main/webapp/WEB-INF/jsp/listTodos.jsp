<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title> List Todos Page </title>

		<link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	</head>
	<body>
    <h1>Welcome ${name}!</h1>
    <hr>
	<h2>Your Todos are</h2>
	<table>
	    <thead>
	        <tr>
	            <th>id</th>
	            <th>description</th>
	            <th>targetDate</th>
	            <th>done</th>
	        </tr>
	    </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
        </tbody>

	</table>
    <script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>