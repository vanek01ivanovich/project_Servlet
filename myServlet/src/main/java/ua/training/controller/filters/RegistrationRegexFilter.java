package ua.training.controller.filters;

import org.mindrot.jbcrypt.BCrypt;
import ua.training.controller.constants.RegexPatternConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegistrationRegexFilter implements Filter, RegexPatternConstants {

    private String firstName;
    private String userName;
    private String lastName;
    private String firstNameUkr;
    private String lastNameUkr;
    private String role;

    private static boolean validFirstName;
    private static boolean validLastName;
    private static boolean validFirstNameUkr;
    private static boolean validLastNameUkr;
    private static boolean validUserName;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String currentUrl = request.getRequestURI();

        if (request.getMethod().equalsIgnoreCase("POST")){
            getAllRequestParametrs(request);
            if (isValid(request)){
                request.setAttribute("regexFalseOrTrue","true");
                filterChain.doFilter(request,response);
            }else{
                request.setAttribute("regexFalseOrTrue","false");
                filterChain.doFilter(request,response);
            }

        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }





    }

    private boolean isValid(HttpServletRequest request){
         validFirstName = nameSurnamePattern.matcher(firstName).matches();
         validLastName = nameSurnamePattern.matcher(lastName).matches();
         validFirstNameUkr = nameSurnameUkrPattern.matcher(firstNameUkr).matches();
         validLastNameUkr = nameSurnameUkrPattern.matcher(lastNameUkr).matches();
         validUserName = userNamePattern.matcher(userName).matches();

        request.setAttribute("validFirstName",validFirstName);
        request.setAttribute("validLastName",validLastName);
        request.setAttribute("validFirstNameUkr",validFirstNameUkr);
        request.setAttribute("validLastNameUkr",validLastNameUkr);
        request.setAttribute("validUserName",validUserName);

        if (validFirstName && validFirstNameUkr && validLastName && validLastNameUkr && validUserName){
            return true;
        }else{
            return false;
        }

    }



    public void getAllRequestParametrs(HttpServletRequest request){
        firstName = request.getParameter("firstName") != null ? request.getParameter("firstName"):"";
        userName = request.getParameter("userName") != null ? request.getParameter("userName"):"";
        lastName = request.getParameter("lastName") != null ? request.getParameter("lastName"):"";
        firstNameUkr = request.getParameter("ukrFirstName") != null ? request.getParameter("ukrFirstName"):"";
        lastNameUkr = request.getParameter("ukrLastName") != null ? request.getParameter("ukrLastName"):"";
    }

    @Override
    public void destroy() {

    }


}
