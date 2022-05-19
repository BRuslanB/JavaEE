package Chapter3.servlets;

import Chapter3.db.DBConnector;
import Chapter3.model.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter3_details")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("student_id");
        Long itemId = null;
        try {
            itemId = Long.parseLong(id);
        }catch (Exception e){
        }
        Students student = DBConnector.getStudent(itemId);
        if (student != null) {
            request.setAttribute("one_student", student);
            request.getRequestDispatcher("Chapter3.Details.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/kz.bitlab.404.jsp").forward(request, response);
        }
    }
}