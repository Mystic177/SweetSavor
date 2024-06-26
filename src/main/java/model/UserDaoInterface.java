package model;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoInterface<T> {
    public void doSave(User user) throws SQLException;
    public boolean doDelete(T obj ) throws SQLException;
    public T retrieveUser(String email, String password) throws SQLException;
    public List<T> retrieveAll() throws SQLException;
    
}