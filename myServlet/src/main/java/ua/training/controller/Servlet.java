package ua.training.controller;

import ua.training.controller.commands.*;
import ua.training.model.service.ApplicationService;
import ua.training.model.service.DestinationPropertyService;
import ua.training.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends  HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init(){
        System.out.println("init");
        commands.put("user",new UserCommand());
        commands.put("admin",new UserCommand());
        commands.put("login",new LoginUserCommand());
        commands.put("logout",new LogoutUserCommand());
        commands.put("registration",new RegistrationCommand(new UserService()));
        commands.put("findroute",new FindRouteCommand(new DestinationPropertyService(),new ApplicationService()));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);


    }

    private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        path = path.replaceAll(".*/","");

        Command command = commands.get(path);
        String page = command.execute(request,response);
        if (page == null){
            HttpSession session = request.getSession();
            response.sendRedirect(session.getAttribute("redirect").toString());
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }

    }




}
