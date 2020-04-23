package ua.training.controller.commands;

import sun.security.krb5.internal.crypto.Des;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DestinationDao;
import ua.training.model.dao.entity.Destination;
import ua.training.model.service.DestinationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FindRouteCommand implements Command {

    private DestinationService destinationService;
    public FindRouteCommand(DestinationService destinationService){this.destinationService = destinationService;}

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {


        if(!request.getParameterMap().isEmpty()){
            List<Destination> destinations = destinationService.getDestinations(request);
            if (!destinations.isEmpty()){
                System.out.println("NOT EMpty");
                System.out.println(destinations.get(0).getPrice());
            }else{
                System.out.println("EMpty");
            }

            return "WEB-INF/view/findRoute.jsp";
        }else{

            return "WEB-INF/view/findRoute.jsp";
        }
    }
}
