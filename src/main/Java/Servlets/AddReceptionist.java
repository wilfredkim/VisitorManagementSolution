package Servlets;

import Entities.Receptionist;
import Enums.Gender;
import Interfaces.ReceptionistI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addReceptionist")
public class AddReceptionist extends Custom {
    @EJB
    ReceptionistI receptionistI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addReceptionist.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();
        Receptionist receptionist = new Receptionist();
        receptionist.setPassword(get(req, "pass"));
        receptionist.setWorkNumber(get(req, "worknum"));
        receptionist.setEmail(get(req, "email"));
        receptionist.setAddress(get(req, "address"));
        receptionist.setPhoneNumber(get(req, "phone"));
        receptionist.setName(get(req, "name"));
        String gend = get(req, "gender");
        if (gend.equals("MALE")) {
            receptionist.setGender(Gender.MALE);
        } else {
            receptionist.setGender(Gender.FEMALE);
        }
        if (receptionistI.add(receptionist)) {
            out.println("Successfully Added");
            resp.sendRedirect("receptionistLogin");
        } else {
            out.println("Could not register");
            out.println("<html><body><p><a href=\"addReceptionist.jsp\">  Try Again </a></p></body></html>");
        }
    }
}

