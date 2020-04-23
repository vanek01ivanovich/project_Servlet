package ua.training.controller.filters;

import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegistrationRegexFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();


        String firstName = request.getParameter("firstName");
        Pattern pattern = Pattern.compile("[A-Z][a-z]{2,20}");

        if (firstName != null) {
            boolean valid = pattern.matcher(firstName).matches();
            if (!valid){
                System.out.println("Invalid");
                session.setAttribute("invalidMes",true);
                //request.setAttribute("invalidMes",true);
                response.sendRedirect("/registration");
            }else{
                System.out.println("valid");
                session.setAttribute("invalidMes",false);
                filterChain.doFilter(request,response);
            }

        }else {
            //session.setAttribute("invalidMes",false);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }


}
