package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class EditUserCommand implements Command {

    private UserService userService;
    private static User user;

    public EditUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (!request.getMethod().equalsIgnoreCase("post")){
            List<User> userList = (List<User>) session.getAttribute("usersList");
            user = userList.stream()
                    .filter(u -> u.getId() == Integer.parseInt(request.getParameter("userId")))
                    .findAny()
                    .orElse(null);
            request.setAttribute("user", user);
            return "/WEB-INF/view/editUser.jsp";
        }else{
            String newUserName = request.getParameter("userName");
            if ((userService.isExistUser(newUserName) && !newUserName.equals(user.getUserName()))
                    || request.getAttribute("regexFalseOrTrue").equals("false")){
                System.out.println("exist");
                user.setUserName(newUserName);
                request.setAttribute("user", user);
                return PageConstants.EDIT_USER_PAGE;
            }else{
                getNewUser(request);
                userService.updateUser(user);
                request.setAttribute("redirect","/admin/allUsers");
                return null;
            }
        }

    }
    private void getNewUser(HttpServletRequest request){
        user.setUserName(request.getParameter("userName"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setFirstNameUkr(request.getParameter("ukrFirstName"));
        user.setLastNameUkr(request.getParameter("ukrLastName"));
        user.setRole(request.getParameter("role"));
    }
}
