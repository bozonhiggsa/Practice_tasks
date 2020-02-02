package ua.examples.practice.practice8;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;
import java.util.List;

@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        String params = context.getInitParameter("sports");
        String[] str = params.split(" ");
        List<String> sports = Arrays.asList(str);
        context.setAttribute("sport", sports);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
