<%@ page import="java.util.ArrayList" %>
<%@ page import="SprintTask2.model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
    <%
        String launchNow = (String) request.getAttribute("user_action");
        //out.print("launchNow="+launchNow);
    %>
</head>
<body onload="loadOnLaunch('<%=launchNow%>')">
    <%@include file="vendor/SprintTask2.Navbar1.jsp"%>
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
    <!-- Modal Login -->
    <div class="modal fade" id="loginModal" data-bs-backdrop="static" data-bs-keyboard="false"
         tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">LOGIN</h5>
                    <button type="button" class="btn-close"
                            data-bs-dismiss="modal" aria-label="Cancel"></button>
                </div>
                <form action="/SprintTask2_login" method="post">
                    <div class="modal-body">
                        <%
                            String userError = request.getParameter("userError");
                            if (userError != null && launchNow.equals("login")) {
                        %>
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Incorrect Login!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                        <%
                            }
                        %>
                        <%
                            String passwordError = request.getParameter("passwordError");
                            if (passwordError != null && launchNow.equals("login")) {
                        %>
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Incorrect Password!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                        <%
                            }
                        %>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="email_value" class="form-label col-2">Login:</label>
                            <input id="email_value" name="email_value" type="email"
                                   class="form-control" required placeholder="Insert email">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="password_value" class="form-label col-2">Password:</label>
                            <input id="password_value" name="password_value" type="password"
                                   class="form-control" required placeholder="Insert password">
                        </div>
                    </div>
                    <div class="modal-footer align-content-end">
                        <button type="button" class="btn btn-secondary"
                                data-bs-dismiss="modal">Cancel</button>
                        <button class="btn btn-success ms-2">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Modal Registration -->
    <div class="modal fade" id="registerModal" data-bs-backdrop="static" data-bs-keyboard="false"
         tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">REGISTRATION</h5>
                    <button type="button" class="btn-close"
                            data-bs-dismiss="modal" aria-label="Cancel"></button>
                </div>
                <form action="/SprintTask2_register" method="post">
                    <div class="modal-body">
                        <%
                            String reg_userError = request.getParameter("userError");
                            if (reg_userError != null && launchNow.equals("register")) {
                        %>
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                User email is busy!
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <%
                            }
                        %>
                        <%
                            String reg_passwordError = request.getParameter("passwordError");
                            if (reg_passwordError != null && launchNow.equals("register")) {
                        %>
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                Incorrect Password!
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <%
                            }
                        %>
                        <%
                            String reg_retypeError = request.getParameter("retypeError");
                            if (reg_retypeError != null && launchNow.equals("register")) {
                        %>
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                Passwords is not same!
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <%
                            }
                        %>
                        <%
                            String reg_success = request.getParameter("success");
                            if (reg_success != null && launchNow.equals("register")) {
                        %>
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                User created successfully!
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <%
                            }
                        %>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="reg_email_value" class="form-label col-2">Email:</label>
                            <input id="reg_email_value" name="email_value" type="email"
                                   class="form-control" required placeholder="Insert email">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="reg_full_name_value" class="form-label col-2">Full Name:</label>
                            <input id="reg_full_name_value" name="full_name_value" type="text"
                                   class="form-control" required placeholder="Insert full name">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="reg_password_value" class="form-label col-2">Password:</label>
                            <input id="reg_password_value" name="password_value" type="password"
                                   class="form-control" required placeholder="Insert password">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="reg_re_password_value" class="form-label col-2">Retype Password:</label>
                            <input id="reg_re_password_value" name="re_password_value" type="password"
                                   class="form-control" required placeholder="Insert password again">
                        </div>
                    </div>
                    <div class="modal-footer align-content-end">
                        <button type="button" class="btn btn-secondary"
                                data-bs-dismiss="modal">Cancel</button>
                        <button class="btn btn-success ms-2">Sign Up</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    function loadOnLaunch(launch) {
        //alert("launch="+launch);
        if (launch != null) {
            if (launch == "login") {
                // вызов модального окна login
                const modal = new bootstrap.Modal(document.querySelector('#loginModal'));
                modal.show();
            } else if (launch == "register") {
                // вызов модального окна registration
                const modal = new bootstrap.Modal(document.querySelector('#registerModal'));
                modal.show();
            }
        }
    }
</script>
</html>