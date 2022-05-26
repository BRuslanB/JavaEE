package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask1_top_sales")
public class TopSalesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Item> topItems = DBConnector.getAllItemTop();
        request.setAttribute("all_items", topItems);
        request.getRequestDispatcher("/SprintTask1.ItemCards.jsp").forward(request, response);
    }
}