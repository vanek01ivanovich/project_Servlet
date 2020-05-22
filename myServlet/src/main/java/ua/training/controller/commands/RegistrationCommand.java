package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class RegistrationCommand implements Command {

    private UserService userService;

    public RegistrationCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter(USER_NAME_PARAMETER);

        if (request.getMethod().equalsIgnoreCase(POST_METHOD)) {

            if ((userService.isExistUser(userName))) {
                request.setAttribute(ALERT_ATTRIBUTE, 0);
                return REGISTRATION_PAGE;
            } else if (request.getAttribute(REGEX_ATTRIBUTE).equals(FALSE_ATTRIBUTE)) {
                request.setAttribute(ALERT_ATTRIBUTE, 1);
                return REGISTRATION_PAGE;
            } else {
                userService.saveNewUser(request);
                request.setAttribute(REDIRECT_ATTRIBUTE, "/login");
                return null;
            }

        }else {
            return REGISTRATION_PAGE;
        }
    }
}
