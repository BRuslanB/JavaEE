<%@ page import="SprintTask1.model.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
  <%@include file="vendor/SprintTask1.Navbar.jsp"%>
  <div class="container">
    <div class="row mt-3">
      <div class="col-12">
        <div class="col-6 mx-auto">
          <%
            String wrong = request.getParameter("wrong");
            if (wrong != null) {
          %>
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <span>Unable to remove the <b>brand</b> that is used in the list of <b>products</b>!</span>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
          <%
            }
          %>
          <%
            Brand brand = (Brand) request.getAttribute("one_brand");
            if (brand != null) {
          %>
          <form action="/SprintTask1_save_brand" method="post">
            <input type="hidden" name="brand_id" value="<%=brand.getId()%>">
            <div class="row mt-3">
              <div class="col-12">
                <label>NAME: </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <input type="text" class="form-control" name="brand_name" required
                       placeholder="Insert name" value="<%=brand.getName()%>">
              </div>
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <label>NAME: </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <input type="text" class="form-control" name="brand_country" required
                       placeholder="Insert country" value="<%=brand.getCountry()%>">
              </div>
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <button class="btn btn-success">SAVE</button>
                <button type="button" class="btn btn-danger ms-2"
                        data-bs-toggle="modal" data-bs-target="#deleteModal">
                  DELETE
                </button>
              </div>
            </div>
          </form>
          <!-- Modal Delete Brand -->
          <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false"
               tabindex="-1" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Delete Brand</h5>
                  <button type="button" class="btn-close"
                          data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="/SprintTask1_delete_brand" method="post">
                  <input type="hidden" name="brand_id" value="<%=brand.getId()%>">
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
        </div>
      </div>
    </div>
  </div>
</body>
</html>