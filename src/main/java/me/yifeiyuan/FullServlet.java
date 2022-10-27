package me.yifeiyuan;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 自定义的 Servlet
 */
@WebServlet(urlPatterns = "/fullServlet")
public class FullServlet implements Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init is called,"+servletConfig);
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service is called");
        servletResponse.getWriter().write("Hello FullServlet");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy is called");
    }
}
