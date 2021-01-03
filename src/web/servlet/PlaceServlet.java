package web.servlet;

import domain.Place;
import service.TravelService;
import service.serviceImp.TravelServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PlaceServlet")
public class PlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TravelService service=new TravelServiceImp();
        List<Place> list=service.FinallPlace();
        Object[] obj=new Object[5];
        for (Place place : list) {
            System.out.println(place.toString());
        }
        request.setAttribute("Place",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
