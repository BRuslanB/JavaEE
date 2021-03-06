package Chapter2.servlets;

import Chapter2.db.DBManager;
import Chapter2.model.Tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add_task")
public class AddTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        try {
            request.getRequestDispatcher("/Chapter2.Task2.AddTask.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/Chapter2.Task2.NotFound.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String deadline = request.getParameter("task_deadline");
        //out.print("add_task.task_deadline " + deadline + "\n");

        Tasks task = new Tasks();
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadline);

        DBManager.addTask(task);

        response.sendRedirect("/");
    }
}