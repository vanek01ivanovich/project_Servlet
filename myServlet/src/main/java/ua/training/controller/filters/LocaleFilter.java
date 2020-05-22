package ua.training.controller.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class LocaleFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {



        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        if (request.getSession().getAttribute(LANG_ATTRIBUTE) == null) {
            request.getSession().setAttribute(LANG_ATTRIBUTE,ENGLISH_ATTRIBUTE);

        }

        if (request.getParameter(LANG_ATTRIBUTE) != null){

            request.getSession().setAttribute(LANG_ATTRIBUTE,request.getParameter(LANG_ATTRIBUTE));

        }

        filterChain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }
}
