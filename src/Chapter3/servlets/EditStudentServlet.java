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
import java.util.ArrayList;

@WebServlet(value = "/chapter3_edit_student")
public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("student_id");
        Long itemId = null;

        try {
            itemId = Long.parseLong(id);

        } catch (Exception e){

        }

        Student student = DBConnector.getStudent(itemId);
        if (student != null) {
            ArrayList<City> cities = DBConnector.getAllCities();
            request.setAttribute("all_cities", cities);
            request.setAttribute("one_student", student);
            request.getRequestDispatcher("Chapter3.EditStudent.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/kz.bitlab.404.jsp").forward(request, response);
        }
    }
}