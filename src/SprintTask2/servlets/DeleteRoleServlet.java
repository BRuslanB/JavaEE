package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_delete_role")
public class DeleteRoleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("role_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        Role role = DBConnector.getRole(Long_id);

        if (role != null) {
            DBConnector.deleteRole(role);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}