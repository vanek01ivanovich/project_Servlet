package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DestinationDao;
import ua.training.model.dao.entity.Destination;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class DestinationService {
    private DaoFactory factory = DaoFactory.getInstance();
    private DestinationDao destinationDao = factory.createDestinationDao();

    public List<Destination> getDestinations(HttpServletRequest destinationRequest){
        String stationFrom = destinationRequest.getParameter("stationFrom");
        String stationTo = destinationRequest.getParameter("stationTo");
        //String date = destinationRequest.getParameter("date");


        return destinationDao.findAllByStationFromAndStationToAndDateDeparture(stationFrom,stationTo);
    }
}
