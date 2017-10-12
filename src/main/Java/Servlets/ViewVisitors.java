package Servlets;

import Entities.Visitor;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "viewVisitor")
public class ViewVisitors extends  Custom {
    @EJB
    VisitorI visitorI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(visitorI.viewAllVisitors()!=null) {
            List<Visitor> visitorList = visitorI.viewAllVisitors();
            req.setAttribute("visitorslist", visitorList);
            RequestDispatcher rd = req.getRequestDispatcher("viewVisitors.jsp");
            rd.forward(req,resp);

        }
    }


}
