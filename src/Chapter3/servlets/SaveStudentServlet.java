package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.City;
import Chapter3.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_save_student")
public class SaveStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        Long id = Long.parseLong(request.getParameter("student_id"));
        String name = request.getParameter("student_name");
        String surname = request.getParameter("student_surname");
        String birthdate = request.getParameter("student_birthdate");
        Long city_id = Long.parseLong(request.getParameter("city_id"));

        Student student = DBConnector.getStudent(id);

        if (student != null) {

            City city = DBConnector.getCity(city_id);

            if (city != null) {
                student.setName(name);
                student.setSurname(surname);
                student.setBirthdate(birthdate);
                student.setCity(city);

                DBConnector.saveStudent(student);
            }
            response.sendRedirect("/chapter3_student_details?student_id=" + id);

        } else {
            response.sendRedirect("/");
        }
    }
}