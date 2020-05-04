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
        System.out.println(session.getAttribute("userName"));
        System.out.println(session.getAttribute("login"));



        //TODO if session login don`t allow user made login only after logout and alert message


        String currentUrl = req.getRequestURI();
       /* System.out.println("HI!");
        System.out.println("Current url = " + currentUrl);
        System.out.println("Session login user filter = " + session.getAttribute("login"));
        System.out.println("Curent = " + (currentUrl.equals("/") || currentUrl.equals("/login")));
        System.out.println("LOGIN = " + (session.getAttribute("login") != null));*/

        if (!(currentUrl.equals("/") || currentUrl.equals("/login")) && session.getAttribute("login") == null){
            System.out.println("dcs");
            res.sendRedirect("/login");
        }else if ((currentUrl.equals("/") || currentUrl.equals("/login")) && session.getAttribute("login") != null){
            if (session.getAttribute("role").equals("ROLE_USER")){
                System.out.println("logout first");
                res.sendRedirect("/user");
            }else{
                System.out.println("logout first");
                res.sendRedirect("admin");
            }
        }else {
            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
