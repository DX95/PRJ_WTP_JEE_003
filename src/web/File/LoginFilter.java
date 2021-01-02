package web.File;

import domain.User;
import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserService service=new UserServiceImp();
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        //获取Cookie
        Cookie[] cookies = request.getCookies();
        String tid=null;
        String pwd=null;
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.equals("tid")){
                    tid=cookie.getValue();
                }else if (cookie.equals("pwd")){
                    pwd=cookie.getValue();
                }
            }
        }
        if (tid!=null&&pwd!=null){
            User login = service.login(tid, pwd);
            if (login!=null){
                request.getSession().setAttribute("login_use",login);
                System.out.println("Login不为空！");
            }
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }


}
