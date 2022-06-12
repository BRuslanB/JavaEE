<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User currentUser = (User) request.getAttribute("current_user");
    //out.print("current_user="+currentUser);
%>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <div class="col-3">
                    <a class="navbar-brand">WORLD NEWS PORTAL</a>
                </div>
                <div class="col-9">
                    <form class="d-flex justify-content-between">
                        <div class="col-10">
                            <input class="form-control" style="background-color: dimgrey;"
                                   type="search" placeholder="Search" aria-label="Search">
                        </div>
                        <div class="col-2">
                            <%
                                if (currentUser != null &&
                                        currentUser.getRole().getName().equals("admin")) {
                            %>
                                <a class="btn btn-outline-success ms-4"
                                   href="/SprintTask2_logout_admin">LOGOUT</a>
                            <%
                                } else {
                            %>
                                <a class="btn btn-outline-success ms-4"
                                   data-bs-toggle="modal" data-bs-target="#loginAdminModal">LOGIN</a>
                            <%
                                }
                            %>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>