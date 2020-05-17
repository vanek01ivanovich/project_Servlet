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
        String currentUrl = req.getRequestURI();

        User user = (User) session.getAttribute("user");

        if (!(currentUrl.equals("/") || currentUrl.equals("/login") || currentUrl.equals("/registration")) && session.getAttribute("login") == null){
            res.sendRedirect("/login");
        }else if ((currentUrl.equals("/") || currentUrl.equals("/login") || currentUrl.equals("/registration")) && session.getAttribute("login") != null){

            if (user.getRole().equals("ROLE_USER")){
                res.sendRedirect("/user");
            }else{
                res.sendRedirect("/admin");
            }
        }else if(currentUrl.equals("/admin") && user.getRole().equals("ROLE_USER")){
            res.sendRedirect("/user");
        }else if(currentUrl.equals("/user") && user.getRole().equals("ROLE_ADMIN")){
            res.sendRedirect("/admin");
        }
        else {
            filterChain.doFilter(request, response);
        }


    }
    @Override
    public void destroy() {

    }
}
