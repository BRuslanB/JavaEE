package kz.bitlab.servlets;

import kz.bitlab.db.DBConnector;
import kz.bitlab.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/kz.bitlab.deleteitem")
public class DeleteItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("item_id"));

        Item item = DBConnector.getItem(id);

        if (item != null) {

            DBConnector.deleteItem(item);

            response.sendRedirect("/");
        }
    }
}