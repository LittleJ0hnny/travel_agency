package com.lv297.travel_agency.database.jdbc.utils.enricher;

import com.lv297.travel_agency.database.entities.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryEnricher extends AbstractEnricher<Country> {
    @Override
    public Country enrichOne(ResultSet resultSet) throws SQLException {
        Country game = null;
        try {
            if(resultSet.next()) {
                game = new Country(resultSet.getInt("counry_id"), resultSet.getString("name"), null);
            }
        } catch (SQLException e) {
            System.out.println("Can`t enrich country");
            throw e;
        }
        return game;
    }
}
