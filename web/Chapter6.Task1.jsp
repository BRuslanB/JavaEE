<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task1</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%
        String cookieValue = (String) request.getAttribute("my_cookie");
    %>
    <script>
        document.title = "<%=cookieValue%>"
    </script>
    <div class="container">
        <div class="row">
            <div class="col-10 mx-auto mt-4">
                <form action="/chapter6_task1_home" method="post">
                    <div class="d-flex justify-content-between">
                        <label for="cookie_value" class="form-label col-2">Name of a Site:</label>
                        <input id="cookie_value" name="cookie_value" type="text" class="form-control" placeholder="Insert name">
                        <div class="col-3 ms-3">
                            <button class="btn btn-secondary">Set Site Name</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>