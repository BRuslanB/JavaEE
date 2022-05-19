<%@ page import="java.util.ArrayList" %>
<%@ page import="Chapter3.model.Students" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <!-- Навигационая панель -->
    <%@include file="vendor/Chapter3.Navbar.jsp"%>
    <div class="container">
        <div class="row mt-3">
            <div class="col-12">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>SURNAME</th>
                        <th>BIRTHDATE</th>
                        <th>CITY</th>
                        <th>DETAILS</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Students> students = (ArrayList<Students>) request.getAttribute("all_students");
                        if (students != null) {
                            for (Students student : students) {
                    %>
                        <tr>
                            <td><% out.print(student.getId());%></td>
                            <td><% out.print(student.getName());%></td>
                            <td><% out.print(student.getSurname());%></td>
                            <td><% out.print(student.getBirthdate());%></td>
                            <td><% out.print(student.getCity());%></td>
                            <td>
                                <a href="/chapter3_details?student_id=<%=student.getId()%>" class="btn btn-primary btn-sm">DETAILS</a>
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
    </div>
</body>
</html>