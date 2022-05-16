<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task2</title>
    <%@include file="vendor/Chapter2.Head.jsp"%>
</head>
<body>
    <!-- Навигационая панель -->
    <%@include file="vendor/Chapter2.Task2.Navbar.jsp"%>
    <div class="container">
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <form action="/add_task" method="post">
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Наименование: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="task_name">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Описание: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                           <textarea type="text" class="form-control" name="task_description"></textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Крайний срок: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="date" class="form-control" name="task_deadline">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-primary">Добавить</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>