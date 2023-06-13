import javax.servlet.*;
import javax.servlet.Filter;
import java.io.IOException;

@javax.servlet.annotation.WebFilter("/calc/expression")
public class ExpressionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
