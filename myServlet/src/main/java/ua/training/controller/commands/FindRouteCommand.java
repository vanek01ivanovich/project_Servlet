package ua.training.controller.commands;

import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.service.ApplicationService;
import ua.training.model.service.DestinationPropertyService;

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

        if(!request.getParameterMap().isEmpty()){


            List<DestinationProperty> destinationProperties = session.getAttribute("lang").equals("en") ?
                    destinationPropertyService.getDestinations( applicationService.addApplication(request)) :
                    destinationPropertyService.getDestinationsByUkrainianApplication(applicationService.addApplication(request));


            if (!destinationProperties.isEmpty()){

                session.setAttribute("listRoutes",destinationProperties);
                System.out.println(destinationProperties.get(0).getPrice());
                System.out.println(destinationProperties.get(1).getPrice());
                session.setAttribute("redirect","/routes");
              return null;

            }else{
                System.out.println("EMpty");
                return "WEB-INF/view/findRoute.jsp";
            }


        }else{

            return "WEB-INF/view/findRoute.jsp";
        }
    }
}
