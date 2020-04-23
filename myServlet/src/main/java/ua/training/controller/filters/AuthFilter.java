package ua.training.controller.filters;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;



        HttpSession session = req.getSession();

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String reqUrl = "";

       if (req.getParameter("userName") != null){

            DaoFactory factory = DaoFactory.getInstance();
            UserDao userDao = factory.createUserDao();

            try {
                User user = userDao.checkLogin(userName, password);
                if (user != null) {
                    if (user.getRole().equals("ROLE_USER")) {
                        reqUrl = "/user";
                    } else {
                        reqUrl = "/admin";
                    }
                    session.setAttribute("userName",userName);
                    session.setAttribute("password",password);

                    res.sendRedirect(reqUrl);
                }else {
                    filterChain.doFilter(request, response);
                }
            }catch (Exception e){
                throw new RuntimeException(e);
            }



        }else {
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
