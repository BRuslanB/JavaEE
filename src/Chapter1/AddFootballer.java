package Chapter1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/addPlayer")
public class AddFootballer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameField");
        String surname = request.getParameter("surnameField");
        String club = request.getParameter("clubField");
        String salary = request.getParameter("salaryField");
        String transfer = request.getParameter("transferField");

        Footballer player = new Footballer();
        player.setName(name);
        player.setSurname(surname);
        player.setClub(club);
        player.setSalary(Integer.parseInt(salary));
        player.setTransferPrice(Integer.parseInt(transfer));

        DBManager.addFootballer(player);

        response.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

    }
}