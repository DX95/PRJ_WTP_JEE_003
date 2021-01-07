package web.servlet;

import domain.Pagebean;
import domain.Trip;
import domain.trip2;
import service.SearchService;
import service.serviceImp.SearchServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String type2 = request.getParameter("type2");
        String currentpages = request.getParameter("Currentpage");
        String rows = request.getParameter("rows");
        System.out.println(type);
        String str=null;
        if (type2!=null&&!type2.equals("")){
            str = new String(type2.getBytes("ISO8859-1"), "UTF-8");
        }
        System.out.println(str);
        int row=0;
        if (rows!=null&&!rows.equals("")){
            row=Integer.parseInt(rows);
        }else {
            row=10;
        }

        int currentpage=0;
        if (currentpages!=null&&!currentpages.equals("")){
            currentpage=Integer.parseInt(currentpages);
        }else {
            currentpage=1;
        }
        Pagebean<trip2> pagebean=null;
       SearchService service=new SearchServiceImp();

        if (str!=null&&!str.equals("")){
           pagebean=service.SearchPagebean(str,row,currentpage);
        }else {
            pagebean=service.SearchPagebean(type,row,currentpage);
        }
       request.setAttribute("PageBean",pagebean);
       if(type!=null&&!type.equals("")){
           request.setAttribute("type",type);
       }
       request.getRequestDispatcher("/search.jsp").forward(request,response);
        //response.getWriter().write(pagebean.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
