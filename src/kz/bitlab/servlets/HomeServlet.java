package kz.bitlab.servlets;

import kz.bitlab.db.DBConnector;
import kz.bitlab.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/kz.bitlab.home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Item> allItems = DBConnector.getAllItem();
        request.setAttribute("tovary", allItems);
        request.getRequestDispatcher("/kz.bitlab.items.jsp").forward(request, response);
    }
}