package Servlets;

import Entities.Visitor;
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
@WebServlet(urlPatterns = "searchVisitor")
public class SearchVisitor extends Custom{
    @EJB
    VisitorI visitorI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd  = req.getRequestDispatcher("searchVisitor.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Visitor visitor = new Visitor();
        visitor.setIdNumber(get(req,"idnum"));
        Visitor visitor1 = visitorI.getById(visitor);
        if(visitor1!=null){
            HttpSession session = req.getSession();
            session.setAttribute("IDNUMBER",get(req,"idnum"));
            resp.sendRedirect("checkIn");

        }else{
            out.println("person does not exist please register first");
            out.println("<html><body><p><a href=\"addVisitor.jsp\">  Try Again </a></p></body></html>");
        }
    }
}
