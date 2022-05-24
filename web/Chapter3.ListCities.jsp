<%@ page import="java.util.ArrayList" %>
<%@ page import="Chapter3.model.City" %>
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
                <a href="/chapter3_add_city" class="btn btn-success btn-sm">+ADD NEW</a>
            </div>
            <div class="col-12">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>CODE</th>
                        <th>DETAILS</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<City> cities = (ArrayList<City>) request.getAttribute("all_cities");
                        if (cities != null) {
                            for (City city : cities) {
                    %>
                        <tr>
                            <td><%=city.getId()%></td>
                            <td><%=city.getName()%></td>
                            <td><%=city.getCode()%></td>
                            <td>
                                <a href="/chapter3_city_details?city_id=<%=city.getId()%>"
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