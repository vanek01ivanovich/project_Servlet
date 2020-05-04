package ua.training.model.service;

import ua.training.model.dao.ApplicationDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.entity.Application;
import ua.training.model.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApplicationService {
    private DaoFactory factory = DaoFactory.getInstance();
    private ApplicationDao applicationDao = factory.createApplicationDao();
    private Application application = new Application();

    public Application addApplication(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String departure = request.getParameter("stationFrom");
        String arrival = request.getParameter("stationTo");
        String date = request.getParameter("date");

        System.out.println(departure);
        System.out.println(arrival);

        application.setDateDeparture(date);
        application.setIdUser(user.getId());

        if (session.getAttribute("lang").equals("en")){
            application.setArrival(arrival);
            application.setDeparture(departure);
            return applicationDao.addApplication(application);
        }else{
            application.setArrivalUA(arrival);
            application.setDepartureUA(departure);
            return applicationDao.addUkrainianApplication(application);
        }



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
