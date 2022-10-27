package me.yifeiyuan;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 自定义 Servlet
 */
public class CustomServlet implements Servlet {

    String name;
    String age;
    public void init(ServletConfig servletConfig) throws ServletException {
        name = servletConfig.getInitParameter("name");
        age = servletConfig.getInitParameter("age");

        System.out.println("name="+name);
        System.out.println("age="+age);

        ServletContext context = servletConfig.getServletContext();
        System.out.println(context);//org.apache.catalina.core.ApplicationContextFacade@1579659

        //todo
        ServletRegistration.Dynamic dynamic = context.addServlet("addedServlet", AddedServlet.class);
        dynamic.setLoadOnStartup(1);
        dynamic.addMapping("/added");
    }

    public ServletConfig getServletConfig() {
        ServletConfig config = new ServletConfig() {
            public String getServletName() {
                return null;
            }

            public ServletContext getServletContext() {
                return null;
            }

            public String getInitParameter(String s) {
                return null;
            }

            public Enumeration<String> getInitParameterNames() {
                return null;
            }
        };
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("CustomServlet service is called");
        servletResponse.getWriter().write("Hello "+name+",you are "+age+" ！six six six");
    }

    public String getServletInfo() {
        return "getServletInfo : CustomServlet ";
    }

    public void destroy() {

    }
}
