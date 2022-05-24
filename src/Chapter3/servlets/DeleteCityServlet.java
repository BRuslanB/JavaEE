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

@WebServlet(value = "/chapter3_delete_city")
public class DeleteCityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("city_id");
        Long c_id = null;

        try {
            c_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        City city = DBConnector.getCity(c_id);

        if (city != null) {
            boolean del = true;
            String redirect = "/chapter3_cities";
            ArrayList<Student> students = DBConnector.getAllStudents();

            if (students != null) {
                for (Student student : students) {
                    if (student.getCity().getId() == c_id) {
                        redirect = "/chapter3_city_details?city_id=" + c_id + "&error";
                        del = false;
                        break;
                    }
                }
            }
            if (del) DBConnector.deleteCity(city);
            response.sendRedirect(redirect);
        }
    }
}