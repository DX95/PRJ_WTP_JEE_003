package web.servlet;

import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service=new UserServiceImp();
        System.out.println("register");
        String tid = request.getParameter("tid");
        Boolean flag=service.register(tid);
        if (flag){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else {
            response.sendRedirect(request.getContextPath()+"/login.jsp?type=regerror");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
