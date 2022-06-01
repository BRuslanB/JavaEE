<%@ page import="Chapter7.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User currentUser = (User) request.getAttribute("current_user");
%>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="/">BITLAB-SHOP</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <%
                        if (currentUser != null) {
                    %>
                        <li class="nav-item">
                            <a class="nav-link fw-bold" href="/chapter7_task3_profile"><%=currentUser.getFull_name()%></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold" href="/chapter7_task3_logout">Logout</a>
                        </li>
                    <%
                        } else {
                    %>
                        <li class="nav-item">
                            <a class="nav-link fw-bold" href="/chapter7_task3_home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold" href="/chapter7_task3_login">Login</a>
                        </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </nav>
</div>