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
            <div class="col-6 mx-auto">
                <form action="/chapter3_add_city" method="post">
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>NAME: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="city_name"
                                   required placeholder="Name: ">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>CODE: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="city_code" maxlength="3"
                                   required placeholder="Code: ">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-success">ADD CITY</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>