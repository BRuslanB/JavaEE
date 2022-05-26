package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.Brand;
import SprintTask1.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask1_item_details")
public class ItemDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("item_id");
        Long itemId = null;

        try {
            itemId = Long.parseLong(id);

        } catch (Exception e) {

        }

        Item item = DBConnector.getItem(itemId);

        if (item != null) {
            ArrayList<Brand> brands = DBConnector.getAllBrand();
            request.setAttribute("all_brands", brands);

            request.setAttribute("one_item", item);
            request.getRequestDispatcher("/SprintTask1.ItemDetails.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/kz.bitlab.404.jsp").forward(request, response);
        }
    }
}