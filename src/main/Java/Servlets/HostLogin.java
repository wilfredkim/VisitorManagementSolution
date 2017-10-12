package Servlets;

import Entities.AuditTrail;
import Entities.Host;
import Events.AuditTrailEvent;
import Interfaces.HostI;
import Interfaces.LoginI;
import Qualifiers.LoginQ;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "hostLogin")
public class HostLogin extends Custom {
    @Inject
    @LoginQ(value = LoginQ.LoginChoice.Host)
    private LoginI loginI;
    @Inject
    private Event<AuditTrailEvent> event;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("hostLogin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        if (loginI.authenticate(get(req, "email"), get(req, "pass"))) {

            HttpSession session = req.getSession();
            session.setAttribute("hostEmail", get(req, "email"));
            Cookie cookie = new Cookie("hostEmail",get(req,"email"));
            resp.addCookie(cookie);
            resp.sendRedirect("hostChat");
            //out.println("sucessfully");
        } else {

            out.println("<html><body><p><a href=\"hostLogin.jsp\">  Try Again </a></p></body></html>");
            out.println("Incorrect password");
        }
    }


}
