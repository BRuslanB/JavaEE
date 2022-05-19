<%@ page import="Chapter3.model.Students" %>
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
            Students student = (Students) request.getAttribute("one_student");
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
                  <input type="text" class="form-control" name="student_city" required
                         placeholder="CITY: " value="<%=student.getCity()%>">
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-12">
                  <button class="btn btn-success">SAVE STUDENT</button>
                  <button type="button" class="btn btn-danger ms-2" data-bs-toggle="modal" data-bs-target="#deleteModal">DELETE STUDENT</button>
                </div>
              </div>
            </form>
            <!-- Modal DELETE -->
            <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title">Delete Student</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <form action="/chapter3_delete_student" method="post">
                    <input type="hidden" name="student_id" value="<%=student.getId()%>">
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