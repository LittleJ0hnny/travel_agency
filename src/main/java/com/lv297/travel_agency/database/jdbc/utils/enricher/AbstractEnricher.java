package com.lv297.travel_agency.database.jdbc.utils.enricher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEnricher <T> {
    public abstract T enrichOne(ResultSet resultSet) throws SQLException;

    public List<T> enrichAll(ResultSet resultSet){
        List<T> list = new ArrayList<>();
        try {
            while (!resultSet.isLast()) {
                list.add(enrichOne(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Can`t enrich object");
        }
        return list;
    }
}
