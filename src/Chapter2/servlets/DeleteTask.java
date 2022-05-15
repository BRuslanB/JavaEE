package Chapter2.servlets;

import Chapter2.db.DBManager;
import Chapter2.model.Tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(value = "/delete_task")
public class DeleteTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        //request.getRequestDispatcher("/Chapter2.Task2.AllTasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String id = request.getParameter("id");
        //out.print("delete_task " + id  + "\n");
        Long taskId = null;
        try {
            taskId = Long.parseLong(id);
        } catch (Exception e) {
        }
        DBManager.deleteTask(taskId);

        response.sendRedirect("/");
    }
}