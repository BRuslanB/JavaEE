package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_add_city")
public class AddCityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Chapter3.AddCity.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String name = request.getParameter("city_name");
        String code = request.getParameter("city_code");

        City city = new City();
        city.setName(name);
        city.setCode(code);

        DBConnector.addCity(city);

        response.sendRedirect("/chapter3_cities");
    }
}