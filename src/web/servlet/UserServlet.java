package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/User/*")
public class UserServlet extends BaseServlet {
    private UserService service=new UserServiceImp();
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("register");
        String tid = request.getParameter("tid");
        Boolean flag=service.register(tid);
        if (flag){
            response.getWriter().write("注册成功！");
        }else {
            response.getWriter().write("您要注册的账号重复！");
        }

    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login");
        String tid = request.getParameter("tid");
        String pwd = request.getParameter("pwd");
        String code=request.getParameter("code");
        User use=service.login(tid,pwd);
        if (use==null){
            response.getWriter().write("用户名或密码错误！");
        }else {
            response.getWriter().write("登录成功！");
        }

    }

}
