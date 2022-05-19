<%@ page import="Chapter2.model.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task1</title>
    <%@include file="vendor/Chapter2.Head.jsp"%>
</head>
<body>
    <!-- Навигационая панель -->
    <%@include file="vendor/Chapter2.Task1.Navbar.jsp"%>
    <div class="container">
        <div class="row">
            <!-- Секции -->
            <%
                ArrayList<News> news = (ArrayList<News>) request.getAttribute("novosti");
                if (news != null) {
                    for (News nw : news) {
                        if (nw.getCategory().equalsIgnoreCase("Cinema")) {
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