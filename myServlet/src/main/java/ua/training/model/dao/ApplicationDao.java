package ua.training.model.dao;

import ua.training.model.dao.entity.Application;

import javax.servlet.http.HttpServletRequest;

public interface ApplicationDao extends GenericDao<Application> {
    Application addApplication(int idUser,String stationFrom,String stationTo,String date);
}
