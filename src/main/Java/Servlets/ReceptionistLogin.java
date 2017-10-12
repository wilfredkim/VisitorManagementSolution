package Servlets;

import Interfaces.LoginI;
import Qualifiers.LoginQ;
import Websockets.ServerEndpoint;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "receptionistLogin")
public class ReceptionistLogin extends  Custom {

    @Inject
    @LoginQ(value = LoginQ.LoginChoice.Receptionist)
    private LoginI loginI;
    @OnOpen
    public void onOpen(Session session){

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd =req.getRequestDispatcher("receptionistLogin.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out  = resp.getWriter();
        resp.setContentType("text/html");


      if(loginI.authenticate(get(req,"email"),get(req,"pass"))){
          HttpSession session = req.getSession();
          session.setAttribute("REmail",get(req,"email"));


      resp.sendRedirect("receptionistPage.jsp");
      }
      else{
          out.println("Incorrect password");
          out.println("<html><body><p><a href=\"receptionistLogin.jsp\">  Try Again </a></p></body></html>");
      }
    }
}
