<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%@include file="vendor/kz.bitlab.navbar.jsp"%>
    <div class="container">
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <form action="/kz.bitlab.additem" method="post">
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>NAME : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="item_name" required placeholder="Name: ">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>DESCRIPTION : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <textarea type="text" class="form-control" name="item_description"
                                      required placeholder="Description: "></textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>PRICE : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="number" step="0.01" max="10000000" min="0"
                                   class="form-control" name="item_price"
                                   required placeholder="Price: ">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-success">ADD ITEM</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>