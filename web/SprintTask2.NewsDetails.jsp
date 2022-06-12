<%@ page import="SprintTask2.model.News" %>
<%@ page import="SprintTask2.model.Comment" %>
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
            <%
                News news = (News) request.getAttribute("one_news");
                if (news != null) {
            %>
                <div class="col-12 card mx-auto my-3">
                    <img src="<%=news.getPicture_url()%>" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text"><%=news.getPublication().getName()%></p>
                        <h5 class="card-title"><%=news.getTitle()%></h5>
                        <p class="card-text"><small class="text-muted"><%=news.getPost_date()%></small></p>
                        <p class="card-text"><%=news.getShort_content()%></p>
                        <p class="card-text"><%=news.getContent()%></p>
                    </div>
                </div>
                <!-- Add Comment -->
                <%
                    if (currentUser != null) {
                %>
                    <div class="col-12 card mx-auto mb-2" style="background-color: whitesmoke;">
                        <div class="card-body">
                            <div class="row mt-2">
                                <div class="col-12">
                                    <form action="/SprintTask2_add_comment" method="post">
                                        <input type="hidden" name="user_id" value="<%=currentUser.getId()%>">
                                        <input type="hidden" name="news_id" value="<%=news.getId()%>">
                                        <input type="hidden" name="public_id" value="<%=news.getPublication().getId()%>">
                                        <div class="col-12">
                                            <textarea class="form-control" name="comment_value"
                                                      required placeholder="Write a comment"></textarea>
                                            <button class="btn btn-success mt-2" onclick="showMessage()">ADD COMMENT</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                <%
                    }
                %>
                <!-- List Comments -->
                <%
                    ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("all_comment");
                    if (comments != null) {
                        for (Comment comment : comments) {

                %>
                    <div class="col-12 card mx-auto mb-2" style="background-color: whitesmoke;">
                        <div class="card-body">
                            <h5><%=comment.getUser().getFull_name()%></h5>
                            <p><%=comment.getComment()%></p>
                            <p>At <i><%=comment.getPost_date()%></i></p>
                        </div>
                    </div>
                <%
                        }
                    }
                %>
            <%
                }
            %>
        </div>
    </div>
</body>
<script type="text/javascript">
    function showMessage(){
        alert("Your comments will be added after moderation!")
    }
</script>
</html>