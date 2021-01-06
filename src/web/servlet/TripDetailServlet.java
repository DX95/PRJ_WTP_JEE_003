package web.servlet;

import domain.trip2;
import service.TripDetailService;
import service.serviceImp.TripDetailServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TripDetailServlet")
public class TripDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TripDetailService service=new TripDetailServiceImp();

        String ids = request.getParameter("id");
        int id=0;
        if (ids!=null&&!ids.equals("")){
            id=Integer.parseInt(ids);
        }
        trip2 trip2=service.findTripDetail(id);
        System.out.println(trip2.toString());
        request.setAttribute("Detail",trip2);
        request.getRequestDispatcher("trip_detail.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
