package kz.bitlab.servlets;

import kz.bitlab.db.DBConnector;
import kz.bitlab.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/kz.bitlab.details")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Long itemId = null;
        try {
            itemId = Long.parseLong(id);
        } catch (Exception e) {
        }
        Item item = DBConnector.getItem(itemId);
        if (item!=null) {
            request.setAttribute("tovar", item);
            request.getRequestDispatcher("/kz.bitlab.details.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/kz.bitlab.404.jsp").forward(request, response);
        }
    }
}