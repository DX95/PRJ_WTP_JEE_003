package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class Per_inf_Servlet extends HttpServlet {
    private UserService service=new UserServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        User user=new User();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String tid = (String) session.getAttribute("tid");
        System.out.println("tid"+tid);

        String sex = request.getParameter("sex");
        String myname = request.getParameter("myname");
        String phone = request.getParameter("mobile");
        String email = request.getParameter("email");
        String real_name = request.getParameter("realname");
        String birthday = request.getParameter("birthday");
        try {
            Date day= dateFormat.parse(birthday);
            user.setBirthday(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        user.setName(myname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setSex(sex);
        user.setReal_name(real_name);
        System.out.println(user.toString());

        service.insert(user,tid);

        User user1=service.selectAll(tid);
        if (user1!=null){
            System.out.println("查询所有后返回的数据："+user1.toString());
            session.setAttribute("use",user1);
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('修改成功！');");
        out.println("window.location = 'http://localhost:8089/PRJ_WTP_JEE_003_war_exploded/index.jsp'");
        out.println("</script>");
        // response.sendRedirect(request.getContextPath()+"/personal_information.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
