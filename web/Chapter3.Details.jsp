<%@ page import="Chapter3.model.Students" %>
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
            Students student = (Students) request.getAttribute("one_student");
            if (student != null) {
          %>
            <form action="/chapter3_edit_student">
              <input type="hidden" name="student_id" value="<%=student.getId()%>">
              <div class="row mt-3">
                <div class="col-12">
                  <label>NAME: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <span class="border_style"><%=student.getName()%></span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>SURNAME: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <span class="border_style"><%=student.getSurname()%></span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>BIRTHDATE: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <span class="border_style"><%=student.getBirthdate()%></span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>CITY: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <span class="border_style"><%=student.getCity()%></span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <button class="btn btn-primary">EDIT STUDENT</button>
                </div>
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