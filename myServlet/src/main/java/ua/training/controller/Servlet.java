package ua.training.controller;


import ua.training.controller.commands.*;
import ua.training.model.service.ApplicationService;
import ua.training.model.service.DestinationPropertyService;
import ua.training.model.service.TicketService;
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
        commands.put("routes",new RoutesCommand());
        commands.put("ticket",new TicketCommand(new TicketService()));
        commands.put("allUsers",new LookAllUsersCommand(new UserService()));
        commands.put("allTickets",new LookAllTicketsCommand(new TicketService()));
       // commands.put("editUser",new LookAllUsersCommand(new UserService()));
        commands.put("editUser",new EditUserCommand(new UserService()));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("post",true);
        processRequest(request,response);

    }

    //TODO regex on everything
    //TODO button click back after logout disable
    //TODO right url (/user/findticket)
    //TODO forbid to redirect from user to admin etc.

    private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String path = request.getRequestURI();

        HttpSession session = request.getSession();

        path = path.replaceAll(".*/","");
        System.out.println(path);




        Command command = commands.get(path);
        String page = command.execute(request,response);
        if (page == null){

            //session = request.getSession();
            response.sendRedirect(request.getAttribute("redirect").toString());
        }else {



            request.getRequestDispatcher(page).forward(request, response);
        }

    }




}
