<%@ page import="Chapter3.model.Student" %>
<%@ page import="Chapter3.model.City" %>
<%@ page import="java.util.ArrayList" %>
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
            Student student = (Student) request.getAttribute("one_student");
            if (student != null) {
          %>
            <form action="/chapter3_save_student" method="post">
              <input type="hidden" name="student_id" value="<%=student.getId()%>">
              <div class="row mt-3">
                <div class="col-12">
                  <label>NAME: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" name="student_name" required
                         placeholder="Name: " value="<%=student.getName()%>">
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>SURNAME: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" name="student_surname" required
                         placeholder="SURNAME: " value="<%=student.getSurname()%>">
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>BIRTHDATE: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <input type="date" class="form-control" name="student_birthdate" required
                         placeholder="BIRTHDATE: " value="<%=student.getBirthdate()%>">
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <label>CITY: </label>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-12">
                  <select name="city_id" class="form-select">
                    <%
                      ArrayList<City> cities = (ArrayList<City>) request.getAttribute("all_cities");
                      if (cities != null) {
                        for (City city : cities) {
                    %>
                          <option value="<%=city.getId()%>" <%=city.getId()==student.getCity().getId() ? "selected" : ""%>>
                            <%=city.getName()%>
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
                  <button class="btn btn-success">SAVE STUDENT</button>
                  <a href="/chapter3_student_details?student_id=<%=student.getId()%>" class="btn btn-secondary">CANCEL</a>                </div>
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