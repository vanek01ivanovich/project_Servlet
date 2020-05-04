package ua.training.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutUserCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        //if (session != null && session.getAttribute("userName") != null){
            /*System.out.println("******LogoutServlet******");
            System.out.println(session.getAttribute("userName"));
            System.out.println(session.getAttribute("login"));

            //session.removeAttribute("login");
            System.out.println(session.getAttribute("userName"));
            System.out.println(session.getAttribute("login"));*/

            session.removeAttribute("userName");
            session.removeAttribute("login");
            session.removeAttribute("role");
            return "WEB-INF/view/login.jsp";
       // }
        //return null;
    }
}
