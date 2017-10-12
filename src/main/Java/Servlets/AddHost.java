package Servlets;

import Entities.Host;
import Entities.Receptionist;
import Enums.Gender;
import Interfaces.HostI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addHost")
public class AddHost extends Custom {
    @EJB
    HostI hostI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addHost.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();
        Host host = new Host();
        host.setPassword(get(req, "pass"));
        host.setWorkNumber(get(req, "worknum"));
        host.setEmail(get(req, "email"));
        host.setAddress(get(req, "address"));
        host.setPhoneNumber(get(req, "phone"));
        host.setName(get(req, "name"));
        String gend = get(req, "gender");
        if (gend.equals("MALE")) {
            host.setGender(Gender.MALE);
        } else {
            host.setGender(Gender.FEMALE);
        }
        if (hostI.add(host)) {
            out.println("Successfully Added");
            resp.sendRedirect("hostLogin");
        } else {
            out.println("Could not register");
            out.println("<html><body><p><a href=\"addHost.jsp\">  Try Again </a></p></body></html>");
        }
    }
}
