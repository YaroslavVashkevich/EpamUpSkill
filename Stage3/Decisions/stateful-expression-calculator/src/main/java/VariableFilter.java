import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@javax.servlet.annotation.WebFilter("/calc/*")
public class VariableFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            filterChain.doFilter(servletRequest, servletResponse);

        }

    @Override
    public void destroy() {

    }
}
