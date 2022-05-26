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

@WebServlet(value = "/SprintTask1_add_item")
public class AddItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("item_name");
        String desc = request.getParameter("item_description");
        String price = request.getParameter("item_price");
        Long brand_id = Long.parseLong(request.getParameter("brand_id"));

        Brand brand = DBConnector.getBrand(brand_id);

        if (brand != null) {
            Item item = new Item();
            item.setName(name);
            item.setDescription(desc);
            item.setPrice(Double.parseDouble(price));
            item.setBrand(brand);

            DBConnector.addItem(item);
        }

        response.sendRedirect("/SprintTask1_item_list");
    }
}