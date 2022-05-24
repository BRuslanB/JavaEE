package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.Student;

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

        String id = request.getParameter("student_id");
        Long s_id = null;

        try {
            s_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        Student student = DBConnector.getStudent(s_id);

        if (student != null) {
            DBConnector.deleteStudent(student);
            response.sendRedirect("/");
        }
    }
}