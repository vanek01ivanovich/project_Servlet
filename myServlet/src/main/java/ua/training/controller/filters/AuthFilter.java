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

    private HttpSession session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;
        session = req.getSession();

        HttpSession session = req.getSession();




        //TODO if session login don`t allow user made login only after logout and alert message


        String currentUrl = req.getRequestURI();



        if (!(currentUrl.equals("/") || currentUrl.equals("/login") || currentUrl.equals("/registration")) && session.getAttribute("login") == null){
            res.sendRedirect("/login");
        }else if ((currentUrl.equals("/") || currentUrl.equals("/login") || currentUrl.equals("/registration")) && session.getAttribute("login") != null){
            User user = (User) session.getAttribute("user");
            if (user.getRole().equals("ROLE_USER")){

                res.sendRedirect("/user");
            }else{

                res.sendRedirect("/admin");
            }
        }else {
            filterChain.doFilter(request, response);
        }


    }
    @Override
    public void destroy() {

    }
}
