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

    /*private String getFormatDate(String city) throws ParseException {
        java.util.Date dateCity = city.getDateU();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        DateFormat format1 = new SimpleDateFormat(pattern);
        String mysqlDateString = format.format(dateCity);

        city.setDate(mysqlDateString);

        return city;
    }*/
}
