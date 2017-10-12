package Servlets;

import Entities.Activity;
import Entities.Visitor;
import Enums.Status;
import Interfaces.ActivityI;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "checkOut")
public class CheckOut extends Custom {
    @EJB
    VisitorI visitorI;
    @EJB
    ActivityI activityI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("checkOut.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Activity activity = new Activity();
        Visitor visitor = new Visitor();
        visitor.setIdNumber(get(req, "idnum"));
        Visitor v = visitorI.getById(visitor);
        if (v != null) {
            v.setStatus(Status.CHECKOUT);
            activity.setDate(new Date());
            activity.setVisitor(v);
            Activity activity1 = activityI.getByVisitorId(activity);
            activity.setPurpose(activity1.getPurpose());
            activity.setPersonVisted(activity1.getPersonVisted());
            activity.setStatus(Status.CHECKOUT);
            activity.setVisitor(v);
            if (visitorI.checkInVisitor(v, activity)) {

                out.println("Successfully checked out");
                out.println("<html><body><p><a href=\"index.jsp\">  Home </a></p></body></html>");

            } else {
                out.println("Could not checkout");
                out.println("<html><body><p><a href=\"checkOut.jsp\">  Try Again </a></p></body></html>");
            }
        } else {
            out.println("person does not exist");
        }
    }
}
