package ua.examples.practice.practice8.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Базовый фильтр, который реализует методы init() и destroy. Благодаря этому его наследники уже могут этого не делать.
 * Кроме того здесь сразу расширяется тип аргументов, благодаря чему наследники уже получают HTTP-аргументы
 */
public abstract class BaseFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
         /*NOP*/
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        doFilter(req, resp, filterChain);
    }

    public abstract void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException;

    public void destroy() {
         /*NOP*/
    }
}
