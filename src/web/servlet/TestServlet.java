package web.servlet;

import domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.UserService;
import service.serviceImp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service=new UserServiceImp();
        PrintWriter writer = response.getWriter();
        try {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart){//判断前台的form是否有mutipart属性
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //通过parseRequest解析from中的所有请求字段，并保存到items集合中
            List<FileItem> Items = upload.parseRequest(request);
            for (FileItem item : Items) {
                //判断前台字段是普通的from表单字段，还是文件字段
                if ( item.isFormField()){
                    String fieldName = item.getFieldName();
                    int sno=-1;
                    String sname=null;
                    if (fieldName.equals("sno")){
                        sno=Integer.parseInt(item.getString("utf-8"));
                    }else if (fieldName.equals("sname")){
                        sname=item.getString("utf-8");
                    }else {
                        System.out.println("其他的文件");
                    }
                }else {
                    //文件上传
                    //getName获取文件名，getFileName获取普通表单字段名
                    String filename = item.getName();
                    //获取文件内容并上传，定义文件路径，指定上传的位置（服务器路径）
                    //String path=request.getSession().getServletContext().getRealPath("upload");
                   // String path=getServletContext().getRealPath("/phono");
                    String path="E:\\IDEA项目\\PRJ_WTP_JEE_003\\web\\img";
                    File file=new File(path,filename);
                    item.write(file);//上传
                    HttpSession session = request.getSession();
                    String tid = (String) session.getAttribute("tid");
                    if (filename!= null) {
                        service.updateheadshout(tid,filename);
                        User user = service.selectAll(tid);
                        System.out.println("head:"+user.toString());
                        session.setAttribute("use", user);
                        request.getRequestDispatcher("personal_information.jsp").forward(request,response);
                        System.out.println(filename+"上传成功！");
                      /*  return;*/
                    } else {
                        writer.println("<script type='text/javascript'>");
                        writer.println("alert(上传失败！);");
                        writer.println("window.location='http://localhost:8089/PRJ_WTP_JEE_003_war_exploded/personal_information.jsp';");
                        writer.println("</script>");
                    }
                }
            }
        }
        } catch (Exception e) {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
