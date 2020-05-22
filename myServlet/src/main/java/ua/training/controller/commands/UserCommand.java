package ua.training.controller.commands;

import ua.training.controller.security.BcryptEncoder;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;
import ua.training.model.dao.entity.enums.RoleStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class UserCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_ATTRIBUTE);

        if (user.getRole() == null){
            return LOGIN_PAGE;
        }else if (user.getRole().equals(RoleStatus.ROLE_USER.toString())){
            request.setAttribute(USER_ATTRIBUTE,user);
            return USER_PAGE;
        }else{
            return ADMIN_PAGE;
        }







    }
}
