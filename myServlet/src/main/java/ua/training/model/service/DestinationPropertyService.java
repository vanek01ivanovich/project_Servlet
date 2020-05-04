package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DestinationPropertyDao;
import ua.training.model.dao.entity.Application;
import ua.training.model.dao.entity.DestinationProperty;

import java.util.List;


public class DestinationPropertyService {
    private DaoFactory factory = DaoFactory.getInstance();
    private DestinationPropertyDao destinationPropertyDao = factory.createDestinationDao();

    public List<DestinationProperty> getDestinations(Application application){
        return destinationPropertyDao.findAllByApplication(application);
    }
    public List<DestinationProperty> getDestinationsByUkrainianApplication(Application application){
        return destinationPropertyDao.findAllByUkrainianApplication(application);
    }


}
