package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_delete_comment")
public class DeleteCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("comment_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        Comment comment = DBConnector.getComment(Long_id);

        if (comment != null) {
            DBConnector.deleteComment(comment);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}