<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Item" %>
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
            <div class="col-12">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>DESCRIPTION</th>
                        <th>PRICE</th>
                        <th>DETAILS</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("tovary");
                        if(items != null){
                            for(Item item : items){
                    %>
                    <tr>
                        <td><% out.print(item.getId());%></td>
                        <td><% out.print(item.getName());%></td>
                        <td><% out.print(item.getDescription());%></td>
                        <td><% out.print(item.getPrice());%></td>
                        <td>
                            <a href="/kz.bitlab.details?id=<%=item.getId()%>"
                               class="btn btn-primary btn-sm">DETAILS</a>
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