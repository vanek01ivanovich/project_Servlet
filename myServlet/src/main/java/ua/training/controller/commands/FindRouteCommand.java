package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.service.ApplicationService;
import ua.training.model.service.DestinationPropertyService;
import static ua.training.controller.constants.PageConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class FindRouteCommand implements Command {

    private HttpSession session;

    private DestinationPropertyService destinationPropertyService;
    private ApplicationService applicationService;
    public FindRouteCommand(DestinationPropertyService destinationPropertyService,ApplicationService applicationService){
        this.destinationPropertyService = destinationPropertyService;
        this.applicationService = applicationService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        session = request.getSession();


        if(request.getMethod().equalsIgnoreCase(POST_METHOD)){


            List<DestinationProperty> destinationProperties = session.getAttribute(LANG_ATTRIBUTE).equals(ENGLISH_ATTRIBUTE) ?
                    destinationPropertyService.getDestinations( applicationService.addApplication(request)) :
                    destinationPropertyService.getDestinationsByUkrainianApplication(applicationService.addApplication(request));


            if (!destinationProperties.isEmpty()){

                request.setAttribute(PAGE_ATTRIBUTE,request.getParameter(PAGE_ATTRIBUTE));
                request.setAttribute(EMPTY_MESSAGE_ATTRIBUTE,false);
                session.setAttribute(LIST_ROUTES_ATTRIBUTE,destinationProperties);

                request.setAttribute(REDIRECT_ATTRIBUTE,"/routes");
              return null;

            }else{
                request.setAttribute(EMPTY_MESSAGE_ATTRIBUTE,true);
                return FIND_ROUTE_PAGE;
            }


        }else{

            return FIND_ROUTE_PAGE;
        }
    }
}
