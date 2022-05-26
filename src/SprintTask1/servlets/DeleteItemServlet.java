package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask1_delete_item")
public class DeleteItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("item_id"));
        Item item = DBConnector.getItem(id);

        if (item != null) {
            DBConnector.deleteItem(item);
            response.sendRedirect("/SprintTask1_item_list");
        }
    }
}