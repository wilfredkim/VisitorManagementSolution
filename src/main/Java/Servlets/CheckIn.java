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
import java.lang.ref.ReferenceQueue;
import java.util.Date;

@WebServlet(urlPatterns = "checkIn")
public class CheckIn extends Custom {
    @EJB
    ActivityI activityI;
    @EJB
    VisitorI visitorI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("checkIn.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Activity activity = new Activity();
        Visitor visitor = new Visitor();
        HttpSession session = req.getSession(false);
        session.getAttribute("IDNUMBER");
        visitor.setIdNumber(String.valueOf(session.getAttribute("IDNUMBER")));

        //getting by Id
        Visitor v = visitorI.getById(visitor);

        if (v != null) {
            v.setStatus(Status.CHECKIN);
            activity.setDate(new Date());
            activity.setPersonVisted(get(req, "personV"));
            activity.setPurpose(get(req, "purpose"));
            activity.setStatus(Status.CHECKIN);
            activity.setVisitor(v);
            if (visitorI.checkInVisitor(v, activity)) {

                //out.println("Successful");
                resp.sendRedirect("receptionistChat.jsp");
            } else {
                out.println("Could not checkIn");
                out.println("<html><body><p><a href=\"checkIn.jsp\">  Try Again </a></p></body></html>");
            }
        }
    }
}
