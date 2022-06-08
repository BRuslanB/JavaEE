<%@ page import="SprintTask2.model.Publication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Long public_id = (Long) request.getAttribute("my_public");
%>
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