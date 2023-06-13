import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/calc")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String formula = req.getParameter("expression");
        Map<String, Integer> operands = getVariables(req);
        formula = replaceVariables(formula, operands);
        MethodOfRecursiveTrigger.LexemeBuffer lexemeBuffer =
                new MethodOfRecursiveTrigger.LexemeBuffer(MethodOfRecursiveTrigger.lexemesAnalyze(formula));
        resp.getWriter().append(String.valueOf((MethodOfRecursiveTrigger.expression(lexemeBuffer)))).close();
    }

    private Map<String, Integer> getVariables(HttpServletRequest req) {
        Map<String, Integer> operands = new LinkedHashMap<>();
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            if (!entry.getKey().equals("expression")) {
                operands.put(entry.getKey(),
                        operands.containsKey(entry.getValue()[0])
                                ? operands.get(entry.getValue()[0])
                                : Integer.parseInt(entry.getValue()[0]));
            }
        }
        return operands;
    }

    private String replaceVariables(String s, Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            s = s.replaceAll(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return s;
    }

}
