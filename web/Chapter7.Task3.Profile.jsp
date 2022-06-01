<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task3->Profile</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%@include file="vendor/Chapter7.Task3.Navbar.jsp"%>
    <div class="container">
        <div class="row mt-3">
            <div class="col-12">
                <h1 class="text-center">
                    HELLO
                    <%
                        if (currentUser != null) {
                            out.print(currentUser.getFull_name());
                        }
                    %>
                    !
                </h1>
            </div>
        </div>
    </div>
</body>
</html>