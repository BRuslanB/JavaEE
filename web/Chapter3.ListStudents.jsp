<%@ page import="java.util.ArrayList" %>
<%@ page import="Chapter3.model.Student" %>
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
                        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("all_students");
                        if (students != null) {
                            for (Student student : students) {
                    %>
                        <tr>
                            <td><%=student.getId()%></td>
                            <td><%=student.getName()%></td>
                            <td><%=student.getSurname()%></td>
                            <td><%=student.getBirthdate()%></td>
                            <td><%=student.getCity().getName()%></td>
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