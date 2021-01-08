package web.servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import domain.User;
import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.invalidate();
        System.out.println("验证码："+checkcode_server);
        UserService service=new UserServiceImp();
        String tid = request.getParameter("tid");
        String pwd = request.getParameter("pwd");
        String code=request.getParameter("code");
        //HttpSession session = request.getSession();
        if (checkcode_server==null||!checkcode_server.equalsIgnoreCase(code)){
            response.sendRedirect(request.getContextPath()+"/login.jsp?type=codeerror");
            return;
        }
        User use=service.login(tid,pwd);
        // System.out.println(use.toString());
        if (use==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp?type=loginerror");
        }else {
            HttpSession session2 = request.getSession();
            //将用户信息存入session域
            session2.setAttribute("use",use);
            //将用户账号存入session域
            session2.setAttribute("tid",tid);
            //保存账号密码到cookie
            Cookie cookie = new Cookie("tid",tid);
            Cookie cookie2 = new Cookie("pwd",pwd);
            cookie.setMaxAge(60*5);
            cookie2.setMaxAge(60*5);
            //发送cookie，完成用户名密码的自动填写
            response.addCookie(cookie);
            response.addCookie(cookie2);

            response.sendRedirect(request.getContextPath()+"/PlaceServlet");
        }
            //response.sendRedirect(request.getContextPath()+"/index.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
