package ua.training.model.dao;

import ua.training.model.dao.entity.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationDao extends GenericDao<Destination>{
    List<Destination> findAllByStationFromAndStationToAndDateDeparture(String stationFrom,
                                                                       String stationTo);
}
