package ua.training.controller.commands;

import ua.training.controller.security.BcryptEncoder;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       /* DaoFactory factory = DaoFactory.getInstance();
        UserDao userDao = factory.createUserDao();
        BcryptEncoder bcryptEncoder = new BcryptEncoder();*/

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //String userName = session.getAttribute("userName").toString();
        //String password = session.getAttribute("password").toString();

        System.out.println("USERCOMMAND = " + user.getRole());


        if (user.getRole() == null){
            return "WEB-INF/view/login.jsp";
        }
        else if (user.getRole().equals("ROLE_USER")){
            request.setAttribute("user",user);
            return "WEB-INF/view/user.jsp";
        }else{
            return "WEB-INF/view/admin.jsp";
        }







    }
}
