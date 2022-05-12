<%@ page import="Chapter2.model.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Chapter2.db.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task1</title>
    <%@include file="vendor/Chapter2.Head.jsp"%>
    <style>
        .bg_color1 {
            background-color: #2F4F4F;
            color: whitesmoke;
        }
        .bg_color2 {
            background-color: #f5f5f5;
            color: black;
        }
        .bg_color3 {
            background-color: #2c3034;
            color: lightgray;
            font-size: smaller;
        }
        .color1 {
            color: gray;
        }
    </style>
</head>
<body>
    <!-- Навигационая панель -->
    <%@include file="vendor/Chapter2.Task1.Navbar.jsp"%>
    <div class="container">
        <div class="row">
            <!-- Секции -->
            <%
                ArrayList<News> news = DBManager.getAllNews();
                //ArrayList<News> news = (ArrayList<News>) request.getAttribute("novosti");
                if (news != null) {
                    for (News nw : news) {
                        if (nw.getCategory().equalsIgnoreCase("Sport")) {
            %>
                <section class="col-12 bg_color2 my-2">
                    <div class="fs-4 fw-bold pt-4 ps-2">
                        <%=nw.getTitle()%>
                    </div>
                    <div class="fs-5 py-1 color1 py-2 ps-2">
                        <%=nw.getContent()%>
                    </div>
                    <div class="fs-6 py-1 color1 pb-5 ps-2">
                        Author:
                        <strong><%=nw.getAuthor()%></strong>
                    </div>
                </section>
            <%
                        }
                    }
                }
            %>
            <!-- Футер -->
            <%@include file="vendor/Chapter2.Task1.Footer.jsp"%>
        </div>
    </div>
</body>
</html>