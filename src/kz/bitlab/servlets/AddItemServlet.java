package kz.bitlab.servlets;

import kz.bitlab.db.DBConnector;
import kz.bitlab.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/kz.bitlab.additem")
public class AddItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/kz.bitlab.additem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("item_name");
        String desc = request.getParameter("item_description");
        String price = request.getParameter("item_price");

        Item item = new Item();
        item.setName(name);
        item.setDescription(desc);
        item.setPrice(Double.parseDouble(price));

        DBConnector.addItem(item);

        response.sendRedirect("/");
    }
}