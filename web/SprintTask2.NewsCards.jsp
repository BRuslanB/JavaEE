<%@ page import="java.util.ArrayList" %>
<%@ page import="SprintTask2.model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%@include file="vendor/SprintTask2.Navbar1.jsp"%>
    <%@include file="vendor/SprintTask2.Navbar2.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-12 my-4" style="border-radius: 5px; border-style: none; background-color: steelblue">
                <h1 class="text-white pt-4 ps-4 pb-2" style="font-family: cursive">All World News</h1>
                <p class="text-white ps-4 pb-4">You can read all news in different around world</p>
            </div>
        </div>
        <div class="row">
            <div class="col-12 card-deck row mx-auto">
                <%
                    ArrayList<News> array_news = (ArrayList<News>) request.getAttribute("all_news");
                    if (array_news != null) {
                        for (News news : array_news) {
                %>
                    <div class="col-6 p-2 mx-auto">
                        <div class="card-group">
                            <div class="card">
                                <img src="<%=news.getPicture_url()%>" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <p class="card-text"><%=news.getPublication().getName()%></p>
                                    <h5 class="card-title"><%=news.getTitle()%></h5>
                                    <p class="card-text"><small class="text-muted"><%=news.getPost_date()%></small></p>
                                    <p class="card-text"><%=news.getShort_content()%></p>
                                    <a class="card-text" style="text-decoration: none"
                                       href="/SprintTask2_news_details?news=<%=news.getId()%>&public=<%=public_id%>">Read More</a>
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