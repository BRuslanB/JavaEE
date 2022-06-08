<%@ page import="SprintTask2.model.Language" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Long lang_id = (Long) request.getAttribute("my_lang");
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
                    <form class="d-flex">
                        <a class="my-auto ms-auto" href="#" style="text-decoration: none">&#128269;</a> <!--исключить-->
                        <button class="btn btn-outline-success ms-auto" type="submit">Sign up</button>
                    </form>
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