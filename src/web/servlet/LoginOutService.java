package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginOutService")
public class LoginOutService extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("cookie");
        request.getSession().invalidate();
        Cookie newCookie=new Cookie("tid",null); //假如要删除名称为username的Cookie
        newCookie.setMaxAge(0); //立即删除型
        newCookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
        response.addCookie(newCookie); //重新写入，将覆盖之前的
        Cookie newCookie2=new Cookie("pwd",null); //假如要删除名称为username的Cookie
        newCookie2.setMaxAge(0); //立即删除型
        newCookie2.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
        response.addCookie(newCookie2); //重新写入，将覆盖之前的

        /*for (Cookie cookie : cookies) {
            if (cookie.getName()=="name"){
                Cookie cookie1 = new Cookie("name",null);
                cookie1.setMaxAge(0);
                response.addCookie(cookie1);
            }else if (cookie.getName()=="pwd"){
                Cookie cookie2 = new Cookie("pwd",null);
                cookie2.setMaxAge(0);
                response.addCookie(cookie2);
            }
        }*/
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
