<%@ page import="Chapter7.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task1->Step2</title>
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
                    <form action="/chapter7_task1_step2" method="post">
                        <input type="hidden" name="name_value" value="<%=student.getName()%>">
                        <input type="hidden" name="surname_value" value="<%=student.getSurname()%>">
                        <input type="hidden" name="age_value" value="<%=student.getAge()%>">
                        <input type="hidden" name="university_value" value="<%=student.getUniversity()%>">
                        <input type="hidden" name="faculty_value" value="<%=student.getFaculty()%>">
                        <input type="hidden" name="group_value" value="<%=student.getGroup()%>">
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="city_value" class="form-label col-2">City:</label>
                            <input id="city_value" name="city_value" type="text" placeholder="Insert city"
                                   class="form-control" value="<%=student.getCity()%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="address_value" class="form-label col-2">Address:</label>
                            <input id="address_value" name="address_value" type="text" placeholder="Insert address"
                                   class="form-control" value="<%=student.getAddress()%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="phone_value" class="form-label col-2">Phone:</label>
                            <input id="phone_value" name="phone_value" type="text" placeholder="Insert phone"
                                   class="form-control" value="<%=student.getPhone()%>">
                        </div>
                        <div class="mt-3 d-flex">
                            <div>
                                <a href="/chapter7_task1_home" class="btn btn-success px-3">BACK</a>
                            </div>
                            <button class="btn btn-success px-3 ms-3">NEXT</button>
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