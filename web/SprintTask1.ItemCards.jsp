<%@ page import="java.util.ArrayList" %>
<%@ page import="SprintTask1.model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%@include file="vendor/SprintTask1.Navbar.jsp"%>
    <div class="bg-white">
        <h2 class="text-center mt-4">Welcome to BITLAB SHOP</h2>
        <p class="text-black-50 text-center">Electronic devices with high quality and service</p>
        <div class="container mx-auto">
            <div class="col-8 card-deck row mx-auto">
                <%
                    ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("all_items");
                    if (items != null) {
                        for (Item item : items) {
                %>
                <div class="col-4 p-2 mx-auto">
                    <div class="card border-light shadow rounded">
                        <div class="card-header bg-light text-center">
                            <%=item.getName()%>
                        </div>
                        <div class="card-body text-center">
                            <h5 class="card-title text-success"><%=item.getPrice()%></h5>
                            <p class="card-text text-black-50"><%=item.getDescription()%></p>
                            <div>
                                <a href="#" class="btn btn-success btn-sm px-5">By Now</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>