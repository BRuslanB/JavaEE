package Chapter3.servlets;

import Chapter3.model.Student;
import Chapter3.db.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/chapter3_home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Student> allStudents = DBConnector.getAllStudents();
        request.setAttribute("all_students", allStudents);
        request.getRequestDispatcher("Chapter3.ListStudents.jsp").forward(request, response);
    }
}