package ua.training.controller.commands;

import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.service.ApplicationService;
import ua.training.model.service.DestinationPropertyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindRouteCommand implements Command {

    private DestinationPropertyService destinationPropertyService;
    private ApplicationService applicationService;
    public FindRouteCommand(DestinationPropertyService destinationPropertyService,ApplicationService applicationService){
        this.destinationPropertyService = destinationPropertyService;
        this.applicationService = applicationService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {


        if(!request.getParameterMap().isEmpty()){


            List<DestinationProperty> destinationProperties = destinationPropertyService.
                    getDestinations( applicationService.addApplication(request));
            if (!destinationProperties.isEmpty()){
                System.out.println("NOT EMpty");
                System.out.println(destinationProperties.get(0).getPrice());
            }else{
                System.out.println("EMpty");
            }

            return "WEB-INF/view/findRoute.jsp";
        }else{

            return "WEB-INF/view/findRoute.jsp";
        }
    }
}
