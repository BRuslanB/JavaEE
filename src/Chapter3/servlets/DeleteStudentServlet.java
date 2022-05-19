package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_delete_student")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("student_id"));
        Students student = DBConnector.getStudent(id);

        if (student != null) {
            DBConnector.deleteStudent(student);
            response.sendRedirect("/");
        }
    }
}