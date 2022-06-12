package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_save_role")
public class SaveRoleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String id = request.getParameter("role_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        String name = request.getParameter("role_name");
        String description = request.getParameter("role_description");

        Role role = DBConnector.getRole(Long_id);

        if (role != null) {
            role.setName(name);
            role.setDescription(description);

            DBConnector.saveRole(role);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}