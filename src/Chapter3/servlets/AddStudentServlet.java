package Chapter3.servlets;

import Chapter3.model.City;
import Chapter3.model.Student;
import Chapter3.db.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/chapter3_add_student")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<City> cities = DBConnector.getAllCities();
        request.setAttribute("all_cities", cities);
        request.getRequestDispatcher("/Chapter3.AddStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String name = request.getParameter("student_name");
        String surname = request.getParameter("student_surname");
        String birthdate = request.getParameter("student_birthdate");
        Long city_id = Long.parseLong(request.getParameter("city_id"));

        City city = DBConnector.getCity(city_id);

        if (city != null) {
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(city);

            DBConnector.addStudent(student);
        }
        response.sendRedirect("/");
    }
}