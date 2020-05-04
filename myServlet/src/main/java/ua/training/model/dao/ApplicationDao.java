package ua.training.model.dao;

import ua.training.model.dao.entity.Application;

import javax.servlet.http.HttpServletRequest;

public interface ApplicationDao extends GenericDao<Application> {
    Application addApplication(Application application);
    Application addUkrainianApplication(Application application);
}
