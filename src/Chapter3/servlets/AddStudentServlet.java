package Chapter3.servlets;

import Chapter3.model.Students;
import Chapter3.db.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_add_student")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/Chapter3.AddStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("student_name");
        String surname = request.getParameter("student_surname");
        String birthdate = request.getParameter("student_birthdate");
        String city = request.getParameter("student_city");

        Students student = new Students();
        student.setName(name);
        student.setSurname(surname);
        student.setBirthdate(birthdate);
        student.setCity(city);

        DBConnector.addStudent(student);

        response.sendRedirect("/");
    }
}