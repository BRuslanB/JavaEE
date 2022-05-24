<%@ page import="Chapter3.model.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
  <!-- Навигационая панель -->
  <%@include file="vendor/Chapter3.Navbar.jsp"%>
  <div class="container">
    <div class="row mt-3">
      <div class="col-12">
        <div class="col-6 mx-auto">
          <%
            City city = (City) request.getAttribute("one_city");
            if (city != null) {
          %>
            <form action="/chapter3_save_city" method="post">
              <input type="hidden" name="city_id" value="<%=city.getId()%>">
              <div class="row mt-3">
                <div class="col-12">
                  <label>NAME: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" name="city_name" required
                         placeholder="Name: " value="<%=city.getName()%>">
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>CODE: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" name="city_code" maxlength="3" required
                         placeholder="CODE: " value="<%=city.getCode()%>">
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <button class="btn btn-success">SAVE CITY</button>
                  <a href="/chapter3_city_details?city_id=<%=city.getId()%>" class="btn btn-secondary">CANCEL</a>                </div>
              </div>
            </form>
          <%
            }
          %>
        </div>
      </div>
    </div>
  </div>
</body>
</html>