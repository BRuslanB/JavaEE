package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask1_add_brand")
public class AddBrandServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("brand_name");
        String country = request.getParameter("brand_country");

        Brand brand = new Brand();
        brand.setName(name);
        brand.setCountry(country);

        DBConnector.addBrand(brand);

        response.sendRedirect("/SprintTask1_brand_list");
    }
}