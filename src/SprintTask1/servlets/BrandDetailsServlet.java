package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask1_brand_details")
public class BrandDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("brand_id");
        Long brandId = null;

        try {
            brandId = Long.parseLong(id);

        } catch (Exception e) {

        }

        Brand brand = DBConnector.getBrand(brandId);

        if (brand != null) {
            request.setAttribute("one_brand", brand);
            request.getRequestDispatcher("/SprintTask1.BrandDetails.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/kz.bitlab.404.jsp").forward(request, response);
        }
    }
}