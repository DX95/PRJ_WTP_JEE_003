package web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    /*protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //获取请求的路径
        String uri = req.getRequestURI();
        //获取方法的名称
        String s = uri.substring(uri.lastIndexOf("/") + 1);
        try {
            //谁调用，this代表谁
            //获取方法对象method
            Method method = this.getClass().getDeclaredMethod(s, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 获取请求标识
            String uri = request.getRequestURI();
            //获取方法的名称
            String s = uri.substring(uri.lastIndexOf("/") + 1);
            // 获取指定类的字节码对象
            //Class<? extends BaseServlet> clazz = this.getClass();//这里的this指的是继承BaseServlet对象
            // 通过类的字节码对象获取方法的字节码对象
            Method method = this.getClass().getMethod(s, HttpServletRequest.class, HttpServletResponse.class);
            // 让方法执行
            method.invoke(this, request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    /**
     * 直接将传入的对象序列化为json，返回给客户端
     * @param obj
     * @param response
     */
    public void writeValue(HttpServletResponse response,Object obj) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),obj);

    }

    /**
     * 将传入的对象序列化为json，返回给调用者
     * @param obj
     * @return
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
