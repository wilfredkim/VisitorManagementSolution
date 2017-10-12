package Servlets;

import Entities.AuditTrail;
import Events.AuditTrailEvent;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
@WebServlet(urlPatterns = "hostLogout")
public class HostLogout  extends Custom {
    @Inject
    private Event<AuditTrailEvent> event;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        session.getAttribute("hostEmail");
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();
        auditTrail.setDate(new Date());
        auditTrail.setDetail("Logout");
        auditTrail.setUserId((String) session.getAttribute("hostEmail"));
        auditTrail.setUserType("Host");
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
        session.invalidate();
        resp.sendRedirect("hostLogin");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
