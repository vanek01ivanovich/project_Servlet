package ua.training.controller.commands;

import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationCommand implements Command{

    private UserService userService;

    public RegistrationCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();

        if (userName != null){
           if(!userService.isExistUser(userName)){
               userService.saveNewUser(request);
               session.setAttribute("redirect","/login");
               return null;
           }else{
               return "WEB-INF/view/registration.jsp";
           }
        }else {
            return "WEB-INF/view/registration.jsp";
        }
    }
}
