package ua.training.model.dao;

import ua.training.model.dao.entity.Application;
import ua.training.model.dao.entity.DestinationProperty;

import java.util.List;

public interface DestinationPropertyDao extends GenericDao<DestinationProperty>{
    List<DestinationProperty> findAllByApplication(Application application);
    List<DestinationProperty> findAllByUkrainianApplication(Application application);
}
