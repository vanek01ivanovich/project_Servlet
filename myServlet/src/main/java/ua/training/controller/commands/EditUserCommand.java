package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageConstants.EDIT_USER_PAGE;
    }
}
