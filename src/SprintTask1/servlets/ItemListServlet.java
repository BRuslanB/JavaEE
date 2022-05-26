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

@WebServlet(value = "/SprintTask1_item_list")
public class ItemListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Brand> brands = DBConnector.getAllBrand();
        request.setAttribute("all_brands", brands);

        ArrayList<Item> allItems = DBConnector.getAllItem();
        request.setAttribute("all_items", allItems);

        request.getRequestDispatcher("/SprintTask1.ItemList.jsp").forward(request, response);
    }
}