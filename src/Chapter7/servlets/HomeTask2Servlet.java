package Chapter7.servlets;

import Chapter7.model.Item;
import Chapter7.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/chapter7_task2_home")
public class HomeTask2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Item[] all_items = new Item[4];
        all_items[0] = new Item(1L, "Adidas F50", 50);
        all_items[1] = new Item(2L, "Reebok R30", 35);
        all_items[2] = new Item(3L, "Nike Total 90", 45);
        all_items[3] = new Item(4L, "Puma 44", 30);

        ArrayList<Item> choose_items = new ArrayList<>();
        HttpSession session = request.getSession();
        choose_items = (ArrayList<Item>) session.getAttribute("choose_items");

        request.setAttribute("choose_items", choose_items);
        request.setAttribute("all_items", all_items);
        request.getRequestDispatcher("/Chapter7.Task2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        Long id = Long.parseLong(request.getParameter("id_value"));
        String name = request.getParameter("name_value");
        double price = Double.parseDouble(request.getParameter("price_value"));

        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setPrice(price);

        ArrayList<Item> choose_items;
        HttpSession session = request.getSession();
        choose_items = (ArrayList<Item>) session.getAttribute("choose_items");

        if (choose_items == null) {
            choose_items = new ArrayList<>();
        }
        choose_items.add(item);

        session.setAttribute("choose_items", choose_items);

        response.sendRedirect("/chapter7_task2_home");
    }
}