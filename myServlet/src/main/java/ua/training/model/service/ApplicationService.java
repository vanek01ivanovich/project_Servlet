package ua.training.model.service;

import ua.training.model.dao.ApplicationDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.entity.Application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApplicationService {
    private DaoFactory factory = DaoFactory.getInstance();
    private ApplicationDao applicationDao = factory.createApplicationDao();

    public Application addApplication(HttpServletRequest request){
        String departure = request.getParameter("stationFrom");
        String arrival = request.getParameter("stationTo");
        String date = request.getParameter("date");

        HttpSession session = request.getSession();
        String iduser = session.getAttribute("iduser").toString();

        return applicationDao.addApplication(Integer.parseInt(iduser),departure,arrival,date);

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
