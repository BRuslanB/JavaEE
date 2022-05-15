<%@ page import="Chapter2.model.Tasks" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Chapter2.db.DBManager" %>
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
        <div class="row">
            <!-- Кнопка добавить -->
            <form action="" method="get">
                <button class="button_style" formaction="/add_task">+ Добавить задание</button>
            </form>
            <!-- Основная область -->
            <table class="table table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Нименование</th>
                        <th>Крайний срок</th>
                        <th>Выполнено</th>
                        <th>Детали</th>
                    </tr>
                </thead>
                <tbody class="color1">
                    <%
                        request.setCharacterEncoding("utf8");
                        ArrayList<Tasks> tasks = (ArrayList<Tasks>) request.getAttribute("zadachi");
                        if (tasks != null) {
                            for (Tasks task : tasks) {
                    %>
                    <tr style="padding: 2px;">
                        <td><% out.print(task.getId());%></td>
                        <td><% out.print(task.getName());%></td>
                        <td><% out.print(task.getDeadlineDate());%></td>
                        <%-- <td><% out.print(task.isStatus());%> --%>
                        <td><%= (task.isStatus() ? "Да" : "Нет")%></td>
                        <td>
                            <a href="/details?id=<%=task.getId()%>" class="btn btn-primary button_style2 btn-sm">Детали</a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>