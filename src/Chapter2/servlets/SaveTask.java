package Chapter2.servlets;

import Chapter2.db.DBManager;
import Chapter2.model.Tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/save_task")
public class SaveTask extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String id = request.getParameter("task_id");
        //out.print("save_task " + id + "\n");

        Long taskId = null;
        try {
            taskId = Long.parseLong(id);
        } catch (Exception e) {
        }

        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String deadline = request.getParameter("task_deadline");
        //out.print("save_task.task_deadline " + deadline + "\n");
        boolean status = Boolean.parseBoolean(request.getParameter("task_status"));

        Tasks task = new Tasks();
        task.setId(taskId);
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadline);
        task.setStatus(status);

        DBManager.saveTask(taskId, task);

        response.sendRedirect("/");
    }
}