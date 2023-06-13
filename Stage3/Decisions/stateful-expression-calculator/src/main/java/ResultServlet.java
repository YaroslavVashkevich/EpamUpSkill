import calc.expression.SolutionExpression;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/calc/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();

        Map<String,String> parameterMap = new HashMap<>();
        String attributeName = "";
        while (attributeNames.hasMoreElements()){
            attributeName = attributeNames.nextElement();
            parameterMap.put(attributeName, (String) session.getAttribute(attributeName));
        }

        String expression = SolutionExpression.expressionMapToString(parameterMap);

        boolean eee = true;
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                continue;
            }else if(chars[i] == ')' || chars[i] == '(' || chars[i] == '*'
            || chars[i] == '/' || chars[i] == '+' || chars[i] == '-' || chars[i] == ' '){
                continue;
            }
            eee = false;
        }

        if(eee) {
            PrintWriter pw = resp.getWriter();
            pw.print(SolutionExpression.solution(expression));
        }else {
            resp.setStatus(409);
        }

    }
}
