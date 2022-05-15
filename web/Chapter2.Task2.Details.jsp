<%@ page import="Chapter2.model.Tasks" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task2</title>
    <%@include file="vendor/Chapter2.Head.jsp"%>
    <style>
        .bg_color1 {
            background-color: darkblue;
            color: white;
        }
        .color1 {
            color: gray;
        }
        .button_style {
            border-style: none;
            border-radius: 1px;
            background-color: darkblue;
            color: whitesmoke;
            padding: 5px 10px;
            margin: 20px 0 20px 0;
        }
    </style>
</head>
<body>
    <%@include file="vendor/Chapter2.Task2.Navbar.jsp"%>
    <div class="container">
        <div class="row mt-3 color1">
            <div class="col-12">
                <div class="col-6 mx-auto">
                    <%
                        //request.setCharacterEncoding("utf8");
                        Tasks task = (Tasks) request.getAttribute("zadacha");
                        if (task != null) {
                    %>
                    <form action="/save_task?id=<%=task.getId()%>" method="post">
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>Наименование: </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" class="form-control" name="task_name"
                                    required value="<%=task.getName()%>">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>Описание: </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                 <textarea type="text" class="form-control"
                                    name="task_description"><%=task.getDescription()%></textarea>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>Крайний срок: </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" class="form-control" name="task_deadline"
                                    required value="<%=task.getDeadlineDate()%>">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>Выполнено: </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                 <select class="form-control" name="task_status"
                                           required value="<%=task.isStatus()%>">
                                     <option value="0">Нет</option>
                                     <option value="1">Да</option>
                                 </select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <button type="submit" class="btn btn-success">Сохранить</button>
                                <button type="submit" class="btn btn-danger ms-1" formaction="/delete_task?id=<%=task.getId()%>">Удалить</button>
                            </div>
                        </div>
                    </form>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</body>
</html>