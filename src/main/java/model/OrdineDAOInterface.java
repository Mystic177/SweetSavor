package model;

import java.sql.SQLException;
import java.util.List;

public interface OrdineDAOInterface {
    void insertOrdine(Ordine ordine) throws SQLException;
    Ordine selectOrdine(String orderID);
    List<Ordine> selectAllOrdini();
    boolean deleteOrdine(String orderID) throws SQLException;
    boolean updateOrdine(Ordine ordine) throws SQLException;
}
