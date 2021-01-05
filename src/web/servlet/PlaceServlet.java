package web.servlet;

import domain.Place;
import domain.Theme;
import domain.trip2;
import service.TravelService;
import service.serviceImp.TravelServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/PlaceServlet")
public class PlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TravelService service=new TravelServiceImp();
        List<Place> Place=service.FinallPlace();
        for (Place place : Place) {
            System.out.println(place.toString());
        }
        HttpSession session = request.getSession();
        session.setAttribute("Place",Place);

        List<Theme> themes=service.finallTheme();
        for (Theme theme: themes) {
            System.out.println(theme);
        }
        session.setAttribute("Theme",themes);

        List<trip2> infs=service.findallInf();
        session.setAttribute("infs",infs);
       /* List<Theme> themes=service.finallTheme();
        for (Theme theme: themes) {
            System.out.println(theme);
        }
        request.setAttribute("Theme",themes);*/
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        //request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
