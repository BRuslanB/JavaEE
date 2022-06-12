package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_delete_user")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("user_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        User user = DBConnector.getUser(Long_id);

        if (user != null) {
            DBConnector.deleteUser(user);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}