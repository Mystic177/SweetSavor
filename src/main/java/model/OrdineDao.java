package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDao implements OrdineDaoInterface {

    @Override
    public void insertOrdine(Ordine ordine) throws SQLException {
        
    }

    @Override
    public Ordine selectOrdine(String orderID) {
        return null;
    }

    @Override
    public ArrayList<Ordine> selectAllOrdini() {
        return null;
    }

    @Override
    public boolean deleteOrdine(String orderID) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrdine(Ordine ordine) throws SQLException {
        return false;
    }
}
