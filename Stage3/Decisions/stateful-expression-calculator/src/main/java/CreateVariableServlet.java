import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/calc/*")
public class CreateVariableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramName = req.getRequestURI().split("/")[2].toLowerCase();
        String paramValue = req.getReader().readLine();

        HttpSession session = req.getSession();

        if(paramValue.matches("[-+]?\\d+") && (Integer.parseInt(paramValue) > 10_000 || Integer.parseInt(paramValue) < -10_000)){
            resp.setStatus(403);
        }else {

            if (session.getAttribute(paramName) == null) {
                session.setAttribute(paramName, paramValue);
                resp.setStatus(201);
            } else {
                session.setAttribute(paramName, paramValue);
                resp.setStatus(200);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramName = req.getRequestURI().split("/")[2].toLowerCase();
        String paramValue = req.getReader().readLine();

        HttpSession session = req.getSession();

        if(session.getAttribute(paramName) != null){
            session.removeAttribute(paramName);
            resp.setStatus(204);
        }

    }
}
