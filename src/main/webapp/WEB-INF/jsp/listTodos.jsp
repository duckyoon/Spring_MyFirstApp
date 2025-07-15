<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Welcome ${name}!</h1>
    <hr>
    <h2>Your Todos are</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>is Done?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <!-- 삭제할 id를 url로 전달 -->
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>
