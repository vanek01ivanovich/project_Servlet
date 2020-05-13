package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        if (!currentUrl.contains("editUser")) {
            user = (User)session.getAttribute("user");
            listUsers = userService.findAllUsers();
            listUsers.removeIf(u -> u.getUserName().equals(user.getUserName()));
            request.setAttribute("allUsers", listUsers);
            return "/WEB-INF/view/allUsers.jsp";
        }else{


            if (request.getAttribute("post") == null) {
                user = listUsers.stream()
                        .filter(u -> u.getId() == Integer.parseInt(request.getParameter("userId")))
                        .findAny()
                        .orElse(null);
                request.setAttribute("user", user);
                return "/WEB-INF/view/editUser.jsp";
            }else{
                System.out.println("OLD = " + user.getUserName());
                String newUserName = request.getParameter("userName");
                if ((userService.isExistUser(newUserName) && !newUserName.equals(user.getUserName()))
                        || request.getAttribute("regexFalseOrTrue").equals("false")){
                    System.out.println("exist");
                    user.setUserName(newUserName);
                    request.setAttribute("user", user);
                    return "/WEB-INF/view/editUser.jsp";
                }else{
                    user.setUserName(request.getParameter("userName"));
                    user.setFirstName(request.getParameter("firstName"));
                    user.setLastName(request.getParameter("lastName"));
                    user.setFirstNameUkr(request.getParameter("ukrFirstName"));
                    user.setLastNameUkr(request.getParameter("ukrLastName"));
                    user.setRole(request.getParameter("role"));
                    userService.updateUser(user);
                    request.setAttribute("redirect","/admin/allUsers");
                    return null;
                }
            }
        }
    }
}
