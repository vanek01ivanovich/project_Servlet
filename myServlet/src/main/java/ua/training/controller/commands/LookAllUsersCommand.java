package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class LookAllUsersCommand implements Command {

    private UserService userService;
    private static List<User> listUsers;
    private static User user;


    public LookAllUsersCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public  String execute(HttpServletRequest request, HttpServletResponse response) {
        String currentUrl = request.getRequestURI();

        HttpSession session = request.getSession();
        if (!request.getMethod().equalsIgnoreCase(POST_METHOD)) {
            user = (User) session.getAttribute(USER_ATTRIBUTE);
            listUsers = userService.findAllUsers();
            listUsers.removeIf(u -> u.getUserName().equals(user.getUserName()));
            request.setAttribute(ALL_USERS_ATTRIBUTE, listUsers);
            session.setAttribute(USERS_LIST_ATTRIBUTES,listUsers);
            return ALL_USERS_PAGE;
        }else{
            user = listUsers.stream()
                    .filter(u -> u.getId() == Integer.parseInt(request.getParameter(USER_ID_PARAMETER)))
                    .findAny()
                    .orElse(null);
            userService.deleteUser(user);
            listUsers.removeIf(u -> u.getUserName().equals(user.getUserName()));
            request.setAttribute(ALL_USERS_ATTRIBUTE, listUsers);
            session.setAttribute(USERS_LIST_ATTRIBUTES,listUsers);
            return ALL_USERS_PAGE;
        }

    }



}
