<%@ page import="Chapter3.model.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@include file="vendor/kz.bitlab.head.jsp"%>
  <style>
    .border_style {
      border: lightgray 1px solid;
      background-color: whitesmoke;
      border-radius: 4px;
      display: block;
      padding: 6px 10px;
      margin: 1px 0 2px 0;
      width: 100%;
    }
  </style>
</head>
<body>
  <!-- Навигационая панель -->
  <%@include file="vendor/Chapter3.Navbar.jsp"%>
  <div class="container">
    <div class="row mt-3">
      <div class="col-12">
        <div class="col-6 mx-auto">
          <%
            String error = request.getParameter("error");
            if (error != null) {
          %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
              Unable to remove the country that is used in the list of students!
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
          <%
            }
          %>
          <%
            City city = (City) request.getAttribute("one_city");
            if (city != null) {
          %>
            <form action="/chapter3_edit_city">
              <input type="hidden" name="city_id" value="<%=city.getId()%>">
              <div class="row mt-3">
                <div class="col-12">
                  <label>NAME: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <span class="border_style"><%=city.getName()%></span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>CODE: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <span class="border_style"><%=city.getCode()%></span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <button class="btn btn-primary">EDIT CITY</button>
                  <button type="button" class="btn btn-danger ms-2" data-bs-toggle="modal" data-bs-target="#deleteModal">DELETE CITY</button>
                </div>
              </div>
            </form>
            <!-- Modal DELETE -->
            <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title">Delete City</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <form action="/chapter3_delete_city" method="post">
                    <input type="hidden" name="city_id" value="<%=city.getId()%>">
                    <div class="modal-body">
                      <h5 class="text-center">
                        Are you sure?
                      </h5>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                      <button class="btn btn-primary">Yes</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          <%
            }
          %>
        </div>
      </div>
    </div>
  </div>
</body>
</html>