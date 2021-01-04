package web.servlet;

import domain.Pagebean;
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
        String currentpages = request.getParameter("Currentpage");
        String rows = request.getParameter("rows");

        String str=null;
        if (type!=null&&!type.equals("")){
            str = new String(type.getBytes("ISO8859-1"), "UTF-8");
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

       SearchService service=new SearchServiceImp();
       Pagebean pagebean=service.SearchPagebean(str,row,currentpage);
       request.setAttribute("pagebean",pagebean);
       request.getRequestDispatcher("search.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
