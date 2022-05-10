package Chapter1.servlets;

import Chapter1.db.DBManager;
import Chapter1.model.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/chapter1.task3")
public class Task3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html lang=\"en\">");
        out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Task 3</title>");
            //out.print("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.print("<style>");
                out.print(".button_style {");
                    out.print("border-style: none;");
                    out.print("border-radius: 0;");
                    out.print("background-color: #00008B;");
                    out.print("color: white;");
                    out.print("padding: 5px 15px;");
                    out.print("margin-left: auto;");
                    out.print("display: block");
                out.print("}");
                out.print(".font1 {");
                    out.print("font-size: 18px;");
                    out.print("font-weight: bold;");
                    out.print("color: #006400;");
                out.print("}");
                out.print(".font2 {");
                    out.print("font-size: 14px;");
                    out.print("font-weight: bold;");
                    out.print("color: #00008B;");
                out.print("}");
                out.print(".font3 {");
                    out.print("font-size: 14px;");
                    out.print("font-weight: bold;");
                    out.print("color: #8B0000;");
                out.print("}");
            out.print("</style>");
        out.print("</head>");
        out.print("<body>");
            out.print("<div class=\"container\">");
                out.print("<div class=\"row\">");
                    out.print("<div class=\"col-6\">");
                        out.print("<form action = '/addPlayer' method = 'post'>");
                            out.print("<div class=\"col\">");
                                out.print("<div class=\"my-4 d-flex justify-content-between\">");
                                    out.print("<label for=\"nameField\" class=\"form-label col-4\">NAME:</label>");
                                    out.print("<input name=\"nameField\" type=\"text\" class=\"form-control\" placeholder=\"Insert name\">");
                                out.print("</div>");
                                out.print("<div class=\"mb-4 d-flex justify-content-between\">");
                                    out.print("<label for=\"surnameField\" class=\"form-label col-4\">SURNAME:</label>");
                                    out.print("<input name=\"surnameField\" type=\"text\" class=\"form-control\" placeholder=\"Insert surname\">");
                                out.print("</div>");
                                out.print("<div class=\"mb-4 d-flex justify-content-between\">");
                                    out.print("<label for=\"clubField\" class=\"form-label col-4\">CLUB:</label>");
                                    out.print("<select name=\"clubField\" class=\"form-control\">");
                                        out.print("<option value=\"No\">---------</option>");
                                        out.print("<option value=\"Real\">Real Madrid FC</option>");
                                        out.print("<option value=\"Chelsea\">Chelsea FC</option>");
                                        out.print("<option value=\"Kairat\">Kairat FC</option>");
                                    out.print("</select>");
                                out.print("</div>");
                                out.print("<div class=\"mb-4 d-flex justify-content-between\">");
                                    out.print("<label for=\"salaryField\" class=\"form-label col-4\">Salary: </label>");
                                    out.print("<input name=\"salaryField\" type=\"text\" value=\"0\" class=\"form-control\" placeholder=\"Insert salary\">");
                                out.print("</div>");
                                out.print("<div class=\"mb-4 d-flex justify-content-between\">");
                                    out.print("<label for=\"transferField\" class=\"form-label col-4\">TRANSFER PRICE:</label>");
                                    out.print("<input name=\"transferField\" type=\"text\" value=\"0\" class=\"form-control\" placeholder=\"Insert transfer price\">");
                                out.print("</div>");
                                out.print("<div class=\"d-flex justify-content-between\">");
                                    out.print("<div class=\"col-4\"></div>");
                                    out.print("<div>");
                                        out.print("<button class=\"button_style\">ADD FOOTBALLER</button>");
                                    out.print("</div>");
                                out.print("</div>");
                            out.print("</div>");
                        out.print("</form>");
                    out.print("</div>");
                    out.print("<div class=\"col-6\">");
                        ArrayList<Footballer> footballers = DBManager.getAllFootballers();
                        for (Footballer player : footballers) {
                            out.print("<div class=\"mx-2\">");
                                out.print("<span class=\"d-block font1\">" + player.getName() + " " + player.getSurname() + "</span>");
                                out.print("<span class=\"d-block font2\">Club: " + player.getClub() + "</span>");
                                out.print("<span class=\"d-block font3\">Salary: " + player.getSalary() + " EUR</span>");
                                out.print("<span class=\"d-block font3\">Transfer price: " + player.getTransferPrice() + " EUR</span>");
                                out.print("<span class=\"d-block\">-----------------------</span>");
                            out.print("</div>");
                        }
                    out.print("</div>");
                out.print("</div>");
            out.print("</div>");
            //out.print("<script src=\"js/bootstrap.bundle.min.js\"></script>");
            out.print("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>");
        out.print("</body>");
        out.print("</html>");
    }
}