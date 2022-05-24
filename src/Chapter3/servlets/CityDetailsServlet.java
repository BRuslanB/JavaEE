package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_city_details")
public class CityDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("city_id");
        Long c_id = null;

        try {
            c_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        City city = DBConnector.getCity(c_id);

        if (city != null) {
            request.setAttribute("one_city", city);
            request.getRequestDispatcher("Chapter3.CityDetails.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/kz.bitlab.404.jsp").forward(request, response);
        }
    }
}