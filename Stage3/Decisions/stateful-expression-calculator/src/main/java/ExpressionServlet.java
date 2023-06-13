import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/calc/expression")
public class ExpressionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = req.getReader().readLine();

        HttpSession session = req.getSession();
        String expression = (String) session.getAttribute("expression");


        if(!s.matches("bad format")) {

            if (expression == null) {
                session.setAttribute("expression", s);
                resp.setStatus(201);
            } else {
                session.setAttribute("expression", s);
                resp.setStatus(200);
            }
        }else {
            resp.setStatus(400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String expression = (String) session.getAttribute("expression");
        if(expression != null){
            session.removeAttribute(expression);
            resp.setStatus(204);
        }
    }
}
