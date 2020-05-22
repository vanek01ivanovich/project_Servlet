package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.controller.constants.RequestConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;

public class EditUserCommand implements Command {

    private UserService userService;
    private static User user;

    public EditUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (!request.getMethod().equalsIgnoreCase(POST_METHOD)){
            List<User> userList = (List<User>) session.getAttribute(USERS_LIST_ATTRIBUTES);
            user = userList.stream()
                    .filter(u -> u.getId() == Integer.parseInt(request.getParameter(RequestConstants.USER_ID_PARAMETER)))
                    .findAny()
                    .orElse(null);
            request.setAttribute(RequestConstants.USER_ATTRIBUTE, user);
            return EDIT_USER_PAGE;
        }else{
            String newUserName = request.getParameter(USER_NAME_PARAMETER);
            if ((userService.isExistUser(newUserName) && !newUserName.equals(user.getUserName()))
                    || request.getAttribute(REGEX_ATTRIBUTE).equals(FALSE_ATTRIBUTE)){
                user.setUserName(newUserName);
                request.setAttribute(USER_ATTRIBUTE, user);
                return EDIT_USER_PAGE;
            }else{
                getNewUser(request);
                userService.updateUser(user);
                request.setAttribute(REDIRECT_ATTRIBUTE,"/admin/allUsers");
                return null;
            }
        }

    }
    private void getNewUser(HttpServletRequest request){
        user.setUserName(request.getParameter(USER_NAME_PARAMETER));
        user.setFirstName(request.getParameter(FIRST_NAME_PARAMETER));
        user.setLastName(request.getParameter(LAST_NAME_PARAMETER));
        user.setFirstNameUkr(request.getParameter(UKR_FIRST_NAME_PARAMETER));
        user.setLastNameUkr(request.getParameter(UKR_LAST_NAME_PARAMETER));
        user.setRole(request.getParameter(ROLE_PARAMETER));
    }
}
