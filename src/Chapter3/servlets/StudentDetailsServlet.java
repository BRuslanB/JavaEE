package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_student_details")
public class StudentDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("student_id");
        Long s_id = null;

        try {
            s_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        Student student = DBConnector.getStudent(s_id);
        if (student != null) {
            request.setAttribute("one_student", student);
            request.getRequestDispatcher("Chapter3.StudentDetails.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/kz.bitlab.404.jsp").forward(request, response);
        }
    }
}