<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Add Todo Page </title>

		<link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="/webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.min.css">
	</head>
	<body>
	<div class="container">
        <h1>Enter Todo Details</h1>
        <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" id="" required="required"/>
                <!-- description에서 에러 발생하면 error 출력 -->
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="targetDate">Target Date</form:label>
                <!-- datepicker 적용-->
                <form:input type="text" path="targetDate" id="targetDate" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>

            <form:input type="hidden" path="id"/>

            <form:input type="hidden" path="done"/>

            <input type="submit" class="btn btn-success"/>

        </form:form>
    </div>
    <script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>

    <!-- datepicker 플러그인 적용 jQuery -->
    <script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
    </script>
	</body>
</html>