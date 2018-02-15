package com.lv297.travel_agency.database.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    List<T> getAll() throws SQLException;
}
