<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

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

<%@ include file="common/footer.jspf" %>

<!-- datepicker 플러그인 적용 jQuery -->
<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
});
</script>
