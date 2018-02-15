package com.lv297.travel_agency.database.jdbc.daoImpls;

import com.lv297.travel_agency.database.dao.CountryDAO;
import com.lv297.travel_agency.database.entities.Country;
import com.lv297.travel_agency.database.jdbc.connection.TransactionManager.TransactionManagerImpl;
import com.lv297.travel_agency.database.jdbc.utils.JdbcUtil;
import com.lv297.travel_agency.database.jdbc.utils.enricher.CountryEnricher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CountryDaoImpl implements CountryDAO {
    private static final CountryEnricher enricher = new CountryEnricher();
    private static final String GET_ALL = "select * from country";

    @Override
    public List<Country> getAll() throws SQLException {
        Connection connection = TransactionManagerImpl.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Country> result = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from country");
            result = enricher.enrichAll(resultSet);
        } catch (SQLException e) {
            System.out.println("Can`t execute query");
        } finally {
            JdbcUtil.closeResultSetQuietly(resultSet);
            JdbcUtil.closeStatementQuietly(statement);
        }
        return result;
    }
}
