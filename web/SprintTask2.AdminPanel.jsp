<%@ page import="java.util.ArrayList" %>
<%@ page import="SprintTask2.model.News" %>
<%@ page import="SprintTask2.model.Language" %>
<%@ page import="SprintTask2.model.Publication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <%@include file="vendor/SprintTask2.Navbar3.jsp"%>
    <div class="container">
        <div class="row d-flex">
            <div class="col-2" style="background-color: lightgray">
                <p class="fw-bold text-center my-3" style="color: darkred;">ADMIN PANEL</p>
                <ul class="navbar-nav">
                    <li class="nav-item my-2">
                        <a href="#" style="color: black; text-decoration: none">Languages</a>
                    </li>
                    <li class="nav-item my-2">
                        <a href="#" style="color: black; text-decoration: none">Publication</a>
                    </li>
                    <li class="nav-item my-2">
                        <a href="#" style="color: black; text-decoration: none">News</a>
                    </li>
                </ul>
            </div>
            <div class="col-10" style="background-color: whitesmoke">
                <div class="col-12">
                   <div class="row mt-3 mx-auto">
                       <!-- Languages head -->
                       <div class="col-12 d-flex justify-content-between">
                           <span style="color: darkred;"><strong>Languages</strong></span>
                           <button type="button" class="btn btn-success btn-sm"
                                   data-bs-toggle="modal" data-bs-target="#addModalLanguage">ADD NEW</button>
                       </div>
                       <!-- Modal Add Language -->
                       <div class="modal fade" id="addModalLanguage" data-bs-backdrop="static" data-bs-keyboard="false"
                            tabindex="-1" aria-hidden="true">
                           <div class="modal-dialog modal-lg">
                               <div class="modal-content">
                                   <div class="modal-header">
                                       <h5 class="modal-title">Add New Language</h5>
                                       <button type="button" class="btn-close"
                                               data-bs-dismiss="modal" aria-label="Close"></button>
                                   </div>
                                   <form action="/SprintTask2_add_language" method="post">
                                       <div class="modal-body">
                                           <div class="row mt-3">
                                               <div class="col-12">
                                                   <label>NAME: </label>
                                               </div>
                                           </div>
                                           <div class="row mt-2">
                                               <div class="col-12">
                                                   <input type="text" class="form-control" name="language_name"
                                                          required placeholder="Insert name">
                                               </div>
                                           </div>
                                           <div class="row mt-3">
                                               <div class="col-12">
                                                   <label>CODE: </label>
                                               </div>
                                           </div>
                                           <div class="row mt-2">
                                               <div class="col-12">
                                                   <input type="text" class="form-control" name="language_code"
                                                          required placeholder="Insert code">
                                               </div>
                                           </div>
                                       </div>
                                       <div class="modal-footer align-content-end">
                                           <button type="button" class="btn btn-secondary"
                                                   data-bs-dismiss="modal">CLOSE</button>
                                           <button class="btn btn-success ms-2">ADD</button>
                                       </div>
                                   </form>
                               </div>
                           </div>
                       </div>
                       <!-- List Languages -->
                       <%
                           ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("all_language");
                           if (languages != null) {
                       %>
                           <div class="col-12">
                               <table class="table table-striped table-hover col-12">
                                   <thead>
                                       <tr>
                                           <th>ID</th>
                                           <th>NAME</th>
                                           <th>CODE</th>
                                           <th>OPERATIONS</th>
                                       </tr>
                                   </thead>
                                   <tbody>
                                   <%
                                       for (Language language : languages) {
                                   %>
                                      <tr>
                                           <td><%=language.getId()%></td>
                                           <td><%=language.getName()%></td>
                                           <td><%=language.getCode()%></td>
                                           <td>
                                               <button type="button" class="btn btn-primary btn-sm"
                                                       data-bs-toggle="modal"
                                                       data-bs-target="#editModalLanguage<%=language.getId()%>">
                                                   EDIT
                                               </button>
                                               <button type="button" class="btn btn-danger btn-sm"
                                                       data-bs-toggle="modal"
                                                       data-bs-target="#deleteModalLanguage<%=language.getId()%>">
                                                   DELETE
                                               </button>
                                           </td>
                                       </tr>
                                       <!-- Modal Edit Language -->
                                       <div class="modal fade" id="editModalLanguage<%=language.getId()%>"
                                            data-bs-backdrop="static" data-bs-keyboard="false"
                                            tabindex="-1" aria-hidden="true">
                                           <div class="modal-dialog modal-lg">
                                               <div class="modal-content">
                                                   <div class="modal-header">
                                                       <h5 class="modal-title">Edit Language</h5>
                                                       <button type="button" class="btn-close"
                                                               data-bs-dismiss="modal" aria-label="Close"></button>
                                                   </div>
                                                   <form action="/SprintTask2_save_language" method="post">
                                                       <input type="hidden" name="language_id"
                                                              value="<%=language.getId()%>">
                                                       <div class="modal-body">
                                                           <div class="row mt-3">
                                                               <div class="col-12">
                                                                   <label>NAME: </label>
                                                               </div>
                                                           </div>
                                                           <div class="row mt-2">
                                                               <div class="col-12">
                                                                   <input type="text" class="form-control"
                                                                          name="language_name"
                                                                          required placeholder="Insert name"
                                                                          value="<%=language.getName()%>">
                                                               </div>
                                                           </div>
                                                           <div class="row mt-3">
                                                               <div class="col-12">
                                                                   <label>CODE: </label>
                                                               </div>
                                                           </div>
                                                           <div class="row mt-2">
                                                               <div class="col-12">
                                                                   <input type="text" class="form-control"
                                                                          name="language_code"
                                                                          required placeholder="Insert code"
                                                                          value="<%=language.getCode()%>">
                                                               </div>
                                                           </div>
                                                       </div>
                                                       <div class="modal-footer align-content-end">
                                                           <button type="button" class="btn btn-secondary"
                                                                   data-bs-dismiss="modal">CLOSE</button>
                                                           <button class="btn btn-success ms-2">SAVE</button>
                                                       </div>
                                                   </form>
                                               </div>
                                           </div>
                                       </div>
                                   <!-- Modal Delete Language -->
                                   <div class="modal fade" id="deleteModalLanguage<%=language.getId()%>"
                                        data-bs-backdrop="static" data-bs-keyboard="false"
                                        tabindex="-1" aria-hidden="true">
                                       <div class="modal-dialog">
                                           <div class="modal-content">
                                               <div class="modal-header">
                                                   <h5 class="modal-title">Delete Language</h5>
                                                   <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                           aria-label="Close"></button>
                                               </div>
                                               <form action="/SprintTask2_delete_language" method="post">
                                                   <input type="hidden" name="language_id" value="<%=language.getId()%>">
                                                   <div class="modal-body">
                                                       <h5 class="text-center">
                                                           Are you sure?
                                                       </h5>
                                                   </div>
                                                   <div class="modal-footer">
                                                       <button type="button" class="btn btn-secondary"
                                                               data-bs-dismiss="modal">Cancel</button>
                                                       <button class="btn btn-primary">Yes</button>
                                                   </div>
                                               </form>
                                           </div>
                                       </div>
                                   </div>
                                   <%
                                      }
                                   %>
                                   </tbody>
                               </table>
                           </div>
                       <%
                           }
                       %>
                   </div>
                </div>
                <div class="col-12">
                    <div class="row mt-3 mx-auto">
                        <!-- Publication head -->
                        <div class="col-12 d-flex justify-content-between">
                            <span style="color: darkred;"><strong>Publications</strong></span>
                            <button type="button" class="btn btn-success btn-sm"
                                    data-bs-toggle="modal" data-bs-target="#addModalPublication">ADD NEW</button>
                        </div>
                        <!-- Modal Add Publication -->
                        <div class="modal fade" id="addModalPublication"
                             data-bs-backdrop="static" data-bs-keyboard="false"
                             tabindex="-1" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Add New Publication</h5>
                                        <button type="button" class="btn-close"
                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <form action="/SprintTask2_add_publication" method="post">
                                        <div class="modal-body">
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>NAME: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <input type="text" class="form-control" name="publication_name"
                                                           required placeholder="Insert name">
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>DESCRIPTION: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <textarea class="form-control" name="publication_description"
                                                              required placeholder="Insert description"></textarea>
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>RATING: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <input type="number" class="form-control" name="publication_rating"
                                                           min="0" max="10" step="0.1"
                                                           required placeholder="Insert rating">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer align-content-end">
                                            <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">CLOSE</button>
                                            <button class="btn btn-success ms-2">ADD</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- List Publications -->
                        <%
                            ArrayList<Publication> publications = (ArrayList<Publication>)
                                    request.getAttribute("all_publication");
                            if (publications != null) {
                        %>
                            <div class="col-12">
                                <table class="table table-striped table-hover col-12">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>NAME</th>
                                        <th>DESCRIPTION</th>
                                        <th>RATING</th>
                                        <th>OPERATIONS</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        for (Publication publication : publications) {
                                    %>
                                        <tr>
                                            <td><%=publication.getId()%></td>
                                            <td><%=publication.getName()%></td>
                                            <td><%=publication.getDescription()%></td>
                                            <td><%=publication.getRating()%></td>
                                            <td>
                                                <button type="button" class="btn btn-primary btn-sm"
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#editModalPublication<%=publication.getId()%>">
                                                    EDIT
                                                </button>
                                                <button type="button" class="btn btn-danger btn-sm"
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#deleteModalPublication<%=publication.getId()%>">
                                                    DELETE
                                                </button>
                                            </td>
                                        </tr>
                                        <!-- Modal Edit Publication -->
                                        <div class="modal fade" id="editModalPublication<%=publication.getId()%>"
                                             data-bs-backdrop="static" data-bs-keyboard="false"
                                             tabindex="-1" aria-hidden="true">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">Edit Publication</h5>
                                                        <button type="button" class="btn-close"
                                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <form action="/SprintTask2_save_publication" method="post">
                                                        <input type="hidden" name="publication_id"
                                                               value="<%=publication.getId()%>">
                                                        <div class="modal-body">
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>NAME: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                                    <input type="text" class="form-control"
                                                                           name="publication_name"
                                                                           required placeholder="Insert name"
                                                                           value="<%=publication.getName()%>">
                                                                </div>
                                                            </div>
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>DESCRIPTION: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                            <textarea class="form-control"
                                                                      name="publication_description"
                                                                      required placeholder="Insert description"
                                                            ><%=publication.getDescription()%></textarea>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>RATING: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                                    <input type="number" class="form-control"
                                                                           name="publication_rating"
                                                                           min="0" max="10" step="0.1"
                                                                           required placeholder="Insert rating"
                                                                           value="<%=publication.getRating()%>">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer align-content-end">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">CLOSE</button>
                                                            <button class="btn btn-success ms-2">SAVE</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    <!-- Modal Delete Publication -->
                                    <div class="modal fade" id="deleteModalPublication<%=publication.getId()%>"
                                         data-bs-backdrop="static" data-bs-keyboard="false"
                                         tabindex="-1" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title">Delete Publication</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                </div>
                                                <form action="/SprintTask2_delete_publication" method="post">
                                                    <input type="hidden" name="publication_id"
                                                           value="<%=publication.getId()%>">
                                                    <div class="modal-body">
                                                        <h5 class="text-center">
                                                            Are you sure?
                                                        </h5>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal">Cancel</button>
                                                        <button class="btn btn-primary">Yes</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="col-12">
                    <div class="row mt-3 mx-auto">
                        <!-- News head -->
                        <div class="col-12 d-flex justify-content-between">
                            <span style="color: darkred;"><strong>News</strong></span>
                            <button type="button" class="btn btn-success btn-sm"
                                    data-bs-toggle="modal" data-bs-target="#addModalNews">ADD NEW</button>
                        </div>
                        <!-- Modal Add News -->
                        <div class="modal fade" id="addModalNews" data-bs-backdrop="static" data-bs-keyboard="false"
                             tabindex="-1" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Add New News</h5>
                                        <button type="button" class="btn-close"
                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <form action="/SprintTask2_add_news" method="post">
                                        <div class="modal-body">
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>TITLE: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <input type="text" class="form-control" name="news_title"
                                                           required placeholder="Insert title">
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>SHORT CONTENT: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <textarea class="form-control" name="news_short_content"
                                                        required placeholder="Insert short content"></textarea>
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>CONTENT: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <textarea class="form-control" name="news_content"
                                                        required placeholder="Insert content"></textarea>
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>LANGUAGE: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <select name="news_language_id" class="form-select" required>
                                                        <%
                                                            if (languages != null) {
                                                                for (Language language : languages) {
                                                        %>
                                                            <option value="<%=language.getId()%>">
                                                                <%=language.getName()%>
                                                            </option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>PUBLICATION: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <select name="news_publication_id" class="form-select" required>
                                                        <%
                                                            if (publications != null) {
                                                                for (Publication publication : publications) {
                                                        %>
                                                            <option value="<%=publication.getId()%>">
                                                                <%=publication.getName()%>
                                                            </option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>PICTURE URL: </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <input type="text" class="form-control" name="news_picture_url"
                                                           required placeholder="Insert picture URL">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer align-content-end">
                                            <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">CLOSE</button>
                                            <button class="btn btn-success ms-2">ADD</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- List News -->
                        <%
                            ArrayList<News> array_news = (ArrayList<News>) request.getAttribute("all_news");
                            if (array_news != null) {
                        %>
                            <div class="col-12">
                                <table class="table table-striped table-hover col-12">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>TITLE</th>
                                            <th>LANGUAGE</th>
                                            <th>ADDED DATE</th>
                                            <th>PUBLICATION</th>
                                            <th>OPERATIONS</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        for (News news : array_news) {
                                    %>
                                        <tr>
                                            <td><%=news.getId()%></td>
                                            <td><%=news.getTitle()%></td>
                                            <td><%=news.getLanguage().getCode()%></td>
                                            <td><%=news.getPost_date()%></td>
                                            <td><%=news.getPublication().getName()%></td>
                                            <td>
                                                <button type="button" class="btn btn-primary btn-sm"
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#editModalNews<%=news.getId()%>">
                                                    EDIT
                                                </button>
                                                <button type="button" class="btn btn-danger btn-sm"
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#deleteModalNews<%=news.getId()%>">
                                                    DELETE
                                                </button>
                                            </td>
                                        </tr>
                                        <!-- Modal Edit News -->
                                        <div class="modal fade" id="editModalNews<%=news.getId()%>"
                                             data-bs-backdrop="static" data-bs-keyboard="false"
                                             tabindex="-1" aria-hidden="true">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">Edit News</h5>
                                                        <button type="button" class="btn-close"
                                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <form action="/SprintTask2_save_news" method="post">
                                                        <input type="hidden" name="news_id"
                                                               value="<%=news.getId()%>">
                                                        <div class="modal-body">
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>TITLE: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                                    <input type="text" class="form-control"
                                                                           name="news_title"
                                                                           required placeholder="Insert title"
                                                                           value="<%=news.getTitle()%>">
                                                                </div>
                                                            </div>
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>SHORT CONTENT: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                            <textarea class="form-control" name="news_short_content"
                                                                      required placeholder="Insert short content"
                                                            ><%=news.getShort_content()%></textarea>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>CONTENT: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                            <textarea class="form-control" name="news_content"
                                                                      required placeholder="Insert content"
                                                            ><%=news.getContent()%></textarea>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>LANGUAGE: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                                    <select name="news_language_id"
                                                                            class="form-select" required>
                                                                        <%
                                                                            if (languages != null) {
                                                                                for (Language language : languages) {
                                                                        %>
                                                                        <option value="<%=language.getId()%>"
                                                                                <%=news.getLanguage().getId()==
                                                                                        language.getId() ?
                                                                                        "selected" : ""%>>
                                                                            <%=language.getName()%>
                                                                        </option>
                                                                        <%
                                                                                }
                                                                            }
                                                                        %>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>PUBLICATION: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                                    <select name="news_publication_id"
                                                                            class="form-select" required>
                                                                        <%
                                                                            if (publications != null) {
                                                                                for (Publication publication :
                                                                                        publications) {
                                                                        %>
                                                                        <option value="<%=publication.getId()%>"
                                                                                <%=news.getPublication().getId()==
                                                                                        publication.getId() ?
                                                                                        "selected" : ""%>>
                                                                            <%=publication.getName()%>
                                                                        </option>
                                                                        <%
                                                                                }
                                                                            }
                                                                        %>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-3">
                                                                <div class="col-12">
                                                                    <label>PICTURE URL: </label>
                                                                </div>
                                                            </div>
                                                            <div class="row mt-2">
                                                                <div class="col-12">
                                                                    <input type="text" class="form-control"
                                                                           name="news_picture_url"
                                                                           required placeholder="Insert picture URL"
                                                                           value="<%=news.getPicture_url()%>">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer align-content-end">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">CLOSE</button>
                                                            <button class="btn btn-success ms-2">SAVE</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Modal Delete News -->
                                        <div class="modal fade" id="deleteModalNews<%=news.getId()%>"
                                             data-bs-backdrop="static" data-bs-keyboard="false"
                                             tabindex="-1" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">Delete News</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                                aria-label="Close"></button>
                                                    </div>
                                                    <form action="/SprintTask2_delete_news" method="post">
                                                        <input type="hidden" name="news_id" value="<%=news.getId()%>">
                                                        <div class="modal-body">
                                                            <h5 class="text-center">
                                                                Are you sure?
                                                            </h5>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">Cancel</button>
                                                            <button class="btn btn-primary">Yes</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>