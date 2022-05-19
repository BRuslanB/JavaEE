package kz.bitlab.servlets;

import kz.bitlab.db.DBConnector;
import kz.bitlab.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/kz.bitlab.saveitem")
public class SaveItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("item_id"));
        String name = request.getParameter("item_name");
        String desc = request.getParameter("item_description");
        String price = request.getParameter("item_price");

        Item item = DBConnector.getItem(id);

        if (item != null) {
            item.setName(name);
            item.setDescription(desc);
            item.setPrice(Double.parseDouble(price));

            DBConnector.saveItem(item);

            response.sendRedirect("/");
        }
    }
}