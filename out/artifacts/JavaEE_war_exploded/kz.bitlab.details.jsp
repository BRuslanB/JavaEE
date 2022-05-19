<%@ page import="kz.bitlab.model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
  <%@include file="vendor/kz.bitlab.navbar.jsp"%>
  <div class="container">
    <div class="row mt-3">
      <div class="col-12">
        <div class="col-6 mx-auto">
          <%
            Item item = (Item) request.getAttribute("tovar");
            if(item!=null){
          %>
          <form action="/kz.bitlab.saveitem" method="post">
            <input type="hidden" name = "item_id" value="<%=item.getId()%>">
            <div class="row mt-3">
              <div class="col-12">
                <label>NAME : </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <input type="text" class="form-control" name="item_name" required
                       placeholder="Name: " value="<%=item.getName()%>">
              </div>
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <label>DESCRIPTION : </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <textarea type="text" class="form-control" name="item_description"
                          required placeholder="Description: "><%=item.getDescription()%></textarea>
              </div>
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <label>PRICE : </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <input type="number" step="0.01"  max="10000000" min="0"
                       class="form-control" name="item_price"
                       placeholder="Price: " value="<%=item.getPrice()%>">
              </div>
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <button class="btn btn-success">SAVE</button>
                <button type="button" class="btn btn-danger ms-2" data-bs-toggle="modal" data-bs-target="#deleteModal">
                  DELETE
                </button>
              </div>
            </div>
          </form>
          <!-- Modal -->
          <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Delete Item</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="/kz.bitlab.deleteitem" method="post">
                  <input type="hidden" name = "item_id" value="<%=item.getId()%>">
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