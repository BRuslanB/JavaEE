package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_add_user")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");
        String full_name = request.getParameter("user_full_name");
        Long role_id = Long.parseLong(request.getParameter("user_role_id"));

        Role role = new Role();
        role.setId(role_id);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFull_name(full_name);
        user.setRole(role);

        DBConnector.addUser(user);

        response.sendRedirect("/SprintTask2_admin_panel");
    }
}