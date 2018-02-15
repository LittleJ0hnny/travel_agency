package com.lv297.travel_agency.database.jdbc.connection.TransactionManager;

import java.util.concurrent.Callable;

public interface TransactionManager {
    <T> T doInTransaction(Callable<T> unitOfWork) throws Exception;
}
