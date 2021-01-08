package web.File;

import domain.User;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;

        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login.jhtml")||requestURI.contains("/login.jsp")||
                requestURI.contains("/code.jhtml")||requestURI.contains("/register.jhtml")||requestURI.contains("/common")
        ||requestURI.contains("/css/")||requestURI.contains("/image_cache/")||requestURI.contains("/images/")||requestURI.contains("/img/")
                ||requestURI.contains("/js/")
        )
        {
            chain.doFilter(request,response);
        }else {
            Object use = request.getSession().getAttribute("use");
            if (use!=null){
                chain.doFilter(request,response);
            }else{
                PrintWriter out = response.getWriter();
                out.println("<script type='text/javascript'>");
                out.println("alert('请先登录！');");
                out.println("window.location = 'http://localhost:8089/PRJ_WTP_JEE_003_war_exploded/login.jsp'");
                out.println("</script>");
            }
        }

    }

    public void destroy() {

    }


}
