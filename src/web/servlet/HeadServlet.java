package web.servlet;

import domain.User;
import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class HeadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("000");
        Part part = request.getPart("image");
      /*  String FileName = part.getSubmittedFileName();
        String newname = System.currentTimeMillis() + FileName.substring(FileName.lastIndexOf("."));*/
        if (part==null){
            return;
        }
        System.out.println(111);
        String cd = part.getHeader("Content-Disposition");
        if (cd==null){
            return;
        }
        System.out.println(222);
        //截取不同类型的文件需要自行判断
        //String filename = cd.substring(cd.lastIndexOf(".")+2, cd.length()-1);
        String newname = cd.substring(cd.lastIndexOf("."));
        System.out.println(newname);

        String realPath = getServletContext().getRealPath("/web/img");
        java.io.File file = new java.io.File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        UserService service=new UserServiceImp();
        part.write(realPath + "/" + newname);
        HttpSession session = request.getSession();
        String tid = (String) session.getAttribute("tid");
        if (tid!= null) {
            service.updateheadshout(tid,newname);
            User user = service.selectAll(tid);
            System.out.println("head:"+user.toString());
            request.setAttribute("use", user);
            request.getRequestDispatcher("personal_information.jsp").forward(request,response);
        } else {
            PrintWriter writer = response.getWriter();
            writer.println("<script type='text/javascript'>");
            writer.println("alert(更新失败！);");
			writer.println("window.location='http://localhost:8089/PRJ_WTP_JEE_003_war_exploded/personal_information.jsp';");
            writer.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
