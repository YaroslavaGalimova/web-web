package ru.itmo.wp.model.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import java.sql.Connection;

import ru.itmo.wp.model.database.DatabaseUtils;
import ru.itmo.wp.model.exception.RepositoryException;

public class BasicRepositoryImpl {
    protected final DataSource DATA_SOURCE = DatabaseUtils.getDataSource(); 
    
    protected ResultSet getResultSet(String command, boolean needGeneratedKeys, List<Object> parameters) {
        try (Connection connection = DATA_SOURCE.getConnection()) {
            try (PreparedStatement statement = needGeneratedKeys ? 
                connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS) : connection.prepareStatement(command)) {

                if (parameters != null) {    
                    int i = 1;
                    for (Object o : parameters) {
                        statement.setObject(i, o);
                        i++;
                    }
                }
                
                if (!needGeneratedKeys) {
                    return statement.executeQuery();
                }
                if (statement.executeUpdate() != 1) {
                    throw new RepositoryException("Can't save.");
                } else {
                    return statement.getGeneratedKeys();
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("Can't find.", e);
        }
    }

}
