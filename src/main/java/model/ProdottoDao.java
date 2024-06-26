package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDao implements ProdottoDaoInterface {
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/SweetSavor";
    private String dbUser = "root";
    private String dbPassword = "root";

    // Metodo privato per ottenere la connessione al database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }
    
    @Override
    public void doSave(Prodotto prodotto) throws SQLException {
        String sql = "INSERT INTO Prodotto (descrizione, prezzo, disponibilita, disponibile, venditore, categoria, imgUrl) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prodotto.getDescrizione());
            stmt.setDouble(2, prodotto.getPrezzo());
            stmt.setInt(3, prodotto.getDisponibilità());
            stmt.setBoolean(4, prodotto.isDisponibile());
            stmt.setString(6, prodotto.getCategoria());
            stmt.setString(7, prodotto.getImgUrl());
            stmt.executeUpdate(); // Usiamo executeUpdate() per eseguire l'INSERT
        }
    }

    @Override
    public boolean doDelete(int idProdotto) throws SQLException {
        return false;
    }

    @Override
    public Prodotto doRetrieveByKey(int idProdotto) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Prodotto> doRetrieveAll(String order) throws SQLException {
        return null;
    }

    @Override
    public void doUpdateQnt(int id, int qnt) throws SQLException {

    }

    @Override
    public void doUpdate(Prodotto bean) throws SQLException {

    }
}