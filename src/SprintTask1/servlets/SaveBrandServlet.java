package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask1_save_brand")
public class SaveBrandServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("brand_id"));
        String name = request.getParameter("brand_name");
        String country = request.getParameter("brand_country");

        Brand brand = DBConnector.getBrand(id);

        if (brand != null) {
            brand.setName(name);
            brand.setCountry(country);

            DBConnector.saveBrand(brand);

            response.sendRedirect("/SprintTask1_brand_list");
        }
    }
}