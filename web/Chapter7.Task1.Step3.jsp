<%@ page import="Chapter7.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task1->Step3</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-6 mx-auto mt-4">
                <%
                    Student student = (Student) request.getAttribute("one_student");
                    if (student != null) {
                %>
                    <form action="/chapter7_task1_step3" method="post">
                        <input type="hidden" name="name_value" value="<%=student.getName()%>">
                        <input type="hidden" name="surname_value" value="<%=student.getSurname()%>">
                        <input type="hidden" name="age_value" value="<%=student.getAge()%>">
                        <input type="hidden" name="city_value" value="<%=student.getCity()%>">
                        <input type="hidden" name="address_value" value="<%=student.getAddress()%>">
                        <input type="hidden" name="phone_value" value="<%=student.getPhone()%>">
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="university_value" class="form-label col-2">University:</label>
                            <input id="university_value" name="university_value" type="text" placeholder="Insert university"
                                   class="form-control" value="<%=student.getUniversity()%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="faculty_value" class="form-label col-2">Faculty:</label>
                            <input id="faculty_value" name="faculty_value" type="text" placeholder="Insert faculty"
                                   class="form-control" value="<%=student.getFaculty()%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="group_value" class="form-label col-2">Group:</label>
                            <input id="group_value" name="group_value" type="text" placeholder="Insert group"
                                   class="form-control" value="<%=student.getGroup()%>">
                        </div>
                        <div class="mt-3 d-flex">
                            <div>
                                <a href="/chapter7_task1_step2" class="btn btn-success px-3">BACK</a>
                            </div>
                            <button class="btn btn-success px-3 ms-3">FINISH</button>
                        </div>
                    </form>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>