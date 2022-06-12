package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_save_user")
public class SaveUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String id = request.getParameter("user_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        String email = request.getParameter("user_email");
        String full_name = request.getParameter("user_full_name");
        Long role_id = Long.parseLong(request.getParameter("user_role_id"));

        User user = DBConnector.getUser(Long_id);

        if (user != null) {

            Role role = DBConnector.getRole(role_id);

            if (role != null) {
                user.setEmail(email);
                user.setFull_name(full_name);
                user.setRole(role);

                DBConnector.saveUser(user);
            }
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}