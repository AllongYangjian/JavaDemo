package com.jiancode.springmvc;

import com.jiancode.springmvc.config.MyConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Description：TODO
 * author：yj
 * email：yj@allong.net
 * date：2019-06-26 13:58
 * version：1.0
 */
public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("--------------------------------");
        AnnotationConfigWebApplicationContext
                ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyConfig.class);
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }*/

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MyConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
}
