package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask1_brand_list")
public class BrandListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Brand> allBrands = DBConnector.getAllBrand();
        request.setAttribute("all_brands", allBrands);
        request.getRequestDispatcher("/SprintTask1.BrandList.jsp").forward(request, response);
    }
}