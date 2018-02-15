package com.lv297.travel_agency.database.jdbc.connection.TransactionManager;

import com.lv297.travel_agency.database.jdbc.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class TransactionManagerImpl implements TransactionManager {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();


    @Override
    public <T> T doInTransaction(Callable<T> unitOfWork) throws Exception {
        Connection connection = JdbcUtil.getConnection();
        connectionHolder.set(connection);
        try {
            T result = unitOfWork.call();
            connection.commit();
            return result;
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            JdbcUtil.closeConnectionQuietly(connection);
            connectionHolder.remove();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection;
        if((connection = connectionHolder.get()) != null) {
            return connection;
        }
        return JdbcUtil.getConnection();
    }
}
