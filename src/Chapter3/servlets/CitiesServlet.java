package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/chapter3_cities")
public class CitiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        ArrayList<City> allCities = DBConnector.getAllCities();
        request.setAttribute("all_cities", allCities);
        request.getRequestDispatcher("Chapter3.ListCities.jsp").forward(request, response);
    }
}