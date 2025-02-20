package ru.itmo.wp.model.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ru.itmo.wp.model.domain.Event;
import ru.itmo.wp.model.exception.RepositoryException;
import ru.itmo.wp.model.repository.EventRepository;

public class EventRepositoryImpl extends BasicRepositoryImpl implements EventRepository{

    @Override
    public void save(Event event) {
        getResultSet("INSERT INTO `Event` (`userId`, `type`, `creationTime`) VALUES (?, ?, NOW())",
        true, List.of(event.getUserId(), event.getType().toString()));
    }
    
}
