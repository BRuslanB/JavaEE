<%@ page import="SprintTask2.model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%@include file="vendor/SprintTask2.Navbar2.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-12 card mx-auto mt-3">
                <%
                    News news = (News) request.getAttribute("one_news");
                    if (news != null) {
                %>
                    <img src="<%=news.getPicture_url()%>" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text"><%=news.getPublication().getName()%></p>
                        <h5 class="card-title"><%=news.getTitle()%></h5>
                        <p class="card-text"><small class="text-muted"><%=news.getPost_date()%></small></p>
                        <p class="card-text"><%=news.getShort_content()%></p>
                        <p class="card-text"><%=news.getContent()%></p>
                    </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>