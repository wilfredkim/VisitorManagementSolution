package Servlets;

import Entities.Visitor;
import Enums.Gender;
import Enums.Status;
import Enums.VisitorCategory;
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

@WebServlet(urlPatterns = "addvisitor")
public class AddVisitor extends Custom {
    @EJB
    VisitorI visitorI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("addVisitor.jsp");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter  out  = resp.getWriter();
        Visitor visitor = new Visitor();
        visitor.setIdNumber(get(req,"idnum"));
        visitor.setEmail(get(req,"email"));
        visitor.setName(get(req,"name"));
        visitor.setAddress(get(req,"address"));
        visitor.setPhoneNumber(get(req,"phone"));
        visitor.setStatus(Status.CHECKOUT);
        String gend = get(req,"gender");

        if(gend.equals("MALE")){
            visitor.setGender(Gender.MALE);
        } else {
            visitor.setGender(Gender.FEMALE);
        }
        if(get(req,"category").equals("VIP")){
            visitor.setVisitorCategory(VisitorCategory.VIP);
        }else{
            visitor.setVisitorCategory(VisitorCategory.NORMAL);
        }
        if(visitorI.add(visitor)){
            HttpSession session = req.getSession();
            session.setAttribute("IDNUMBER",get(req,"idnum"));
            resp.sendRedirect("checkIn");
        } else{
            out.println("Could not register");
            out.println("<html><body><p><a href=\"addVisitor.jsp\">  Try Again </a></p></body></html>");
        }

    }
}
