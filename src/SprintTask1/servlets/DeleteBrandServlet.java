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

import static SprintTask1.db.DBConnector.getAllItem;

@WebServlet(value = "/SprintTask1_delete_brand")
public class DeleteBrandServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("brand_id"));
        Brand brand = DBConnector.getBrand(id);

        if (brand != null) {
            boolean del = true;
            String redirect = "/SprintTask1_brand_list";
            ArrayList<Item> items = getAllItem();

            if (items != null) {
                for (Item item : items) {
                    if (item.getBrand().getId() == id) {
                        redirect = "/SprintTask1_brand_details?brand_id=" + id + "&wrong";
                        del = false;
                        break;
                    }
                }
            }
            if (del) DBConnector.deleteBrand(brand);
            response.sendRedirect(redirect);
        }
    }
}