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


        if(request.getMethod().equalsIgnoreCase("post")){


            List<DestinationProperty> destinationProperties = session.getAttribute("lang").equals("en") ?
                    destinationPropertyService.getDestinations( applicationService.addApplication(request)) :
                    destinationPropertyService.getDestinationsByUkrainianApplication(applicationService.addApplication(request));


            if (!destinationProperties.isEmpty()){


                request.setAttribute("emptyMessage",false);
                session.setAttribute("listRoutes",destinationProperties);

                request.setAttribute("redirect","/routes");
              return null;

            }else{
                request.setAttribute("emptyMessage",true);
                System.out.println("EMpty");
                return "WEB-INF/view/findRoute.jsp";
            }


        }else{

            return "WEB-INF/view/findRoute.jsp";
        }
    }
}
