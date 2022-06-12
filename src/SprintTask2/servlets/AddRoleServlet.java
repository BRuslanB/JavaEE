package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_add_role")
public class AddRoleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String name = request.getParameter("role_name");
        String description = request.getParameter("role_description");

        Role role = new Role();
        role.setName(name);
        role.setDescription(description);

        DBConnector.addRole(role);

        response.sendRedirect("/SprintTask2_admin_panel");
    }
}