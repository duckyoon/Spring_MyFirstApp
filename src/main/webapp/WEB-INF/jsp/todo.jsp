<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Add Todo Page </title>

		<link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	</head>
	<body>
	<div class="container">
        <h1>Enter Todo Details</h1>
        <form:form method="post" modelAttribute="todo">

            Description: <form:input type="text" path="description" id="" required="required"/>
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>
            <input type="submit" class="btn btn-success"/>

        </form:form>
    </div>
    <script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>