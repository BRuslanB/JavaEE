<%@ page import="SprintTask2.model.Language" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="SprintTask2.model.User" %>
<%@ page import="SprintTask2.model.Publication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Long lang_id = (Long) request.getAttribute("my_lang");
    Long public_id = (Long) request.getAttribute("my_public");
    User currentUser = (User) request.getAttribute("current_user");
    //out.print("current_user="+currentUser);
%>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: whitesmoke;">
            <div class="container-fluid d-flex justify-content-between">
                <div class="collapse navbar-collapse col-3">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <%
                            ArrayList<Language> languages = (ArrayList<Language>)
                                    request.getAttribute("all_language");
                            if (languages != null) {
                                for (Language language : languages) {
                        %>
                            <li class="nav-item">
                                <a class="nav-link <%=language.getId() == lang_id ? "fw-bold" : ""%>"
                                   href="/SprintTask2_change_language?lang=<%=language.getId()%>"
                                     ><%=language.getCode()%></a>
                            </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                </div>
                <div class="text-center col-7">
                    <a class="navbar-brand fw-bold" href="/SprintTask2_remove_cookies"
                       style="color: darkred;">WORLD NEWS PORTAL</a>
                </div>
                <div class="col-2 text-end">
                    <ul class="navbar-nav mb-2 mb-lg-0">
                        <li class="nav-item">
                            <%
                                if (currentUser != null) {
                            %>
                            <a class="nav-link fw-bold" href="#"><%=currentUser.getFull_name()%></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/SprintTask2_logout">LOGOUT</a>
                            <%
                                } else {
                            %>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn" data-bs-toggle="modal" data-bs-target="#registerModal">SIGN UP</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn" data-bs-toggle="modal" data-bs-target="#loginModal">LOGIN</a>
                            <%
                                }
                            %>
                        </li>
                    </ul>
                </div>
                <div>
                    <button class="navbar-toggler" type="button"
                            data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark" style="color: white; background-color: #2F4F4F;">
            <div class="container-fluid d-flex justify-content-between">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <%
                            ArrayList<Publication> publications = (ArrayList<Publication>)
                                    request.getAttribute("all_publication");
                            if (publications != null) {
                                for (Publication publication : publications) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link <%=publication.getId() == public_id ? "fw-bold" : ""%>"
                               href="/SprintTask2_change_publication?public=<%=publication.getId()%>"
                            ><%=publication.getName()%></a>

                        </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                </div>
                <div>
                    <button class="navbar-toggler" type="button"
                            data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </div>
        </nav>
    </div>
</div>