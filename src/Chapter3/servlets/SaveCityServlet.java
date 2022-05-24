package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_save_city")
public class SaveCityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String id = request.getParameter("city_id");
        Long c_id = null;

        try {
            c_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        String name = request.getParameter("city_name");
        String code = request.getParameter("city_code");

        City city = DBConnector.getCity(c_id);

        if (city != null) {
                city.setName(name);
                city.setCode(code);

                DBConnector.saveCity(city);
        }

        response.sendRedirect("/chapter3_city_details?city_id=" + c_id);
    }
}