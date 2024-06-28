package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProdottoDaoInterface {

    public void doSave(Prodotto prodotto) throws SQLException;

    public boolean doDelete(int idProdotto) throws SQLException;


    public Prodotto doRetrieveByKey(int idProdotto) throws SQLException;

    public ArrayList<Prodotto> doRetrieveAll(String order) throws SQLException;

    public void doUpdateQnt(int id, int qnt) throws SQLException;

    public void doUpdate(Prodotto bean) throws SQLException;

}