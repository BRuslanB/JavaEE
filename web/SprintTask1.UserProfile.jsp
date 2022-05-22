<%@ page import="SprintTask1.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%@include file="vendor/SprintTask1.Navbar.jsp"%>
    <div class="bg-white">
        <%
            User user = (User) request.getAttribute("one_user");
            if (user != null) {
        %>
        <h2 class="text-center mt-4">Hello <%=user.getFullName()%></h2>
        <p class="text-black-50 text-center">This is your profile page</p>
        <%
            }
        %>
    </div>
</body>
</html>