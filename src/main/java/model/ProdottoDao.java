package model;

import java.sql.*;
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
        String sql = "INSERT INTO Prodotto (nome,descrizione, prezzo, disponibilita, disponibile, categoria, imgUrl) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,prodotto.getNomeProdotto());
            stmt.setString(2, prodotto.getDescrizione());
            stmt.setDouble(3, prodotto.getPrezzo());
            stmt.setInt(4, prodotto.getDisponibility());
            stmt.setBoolean(5, prodotto.isDisponibile());
            stmt.setString(6, prodotto.getCategoria());
            stmt.setBytes(7, prodotto.getImg());
            stmt.executeUpdate(); // Usiamo executeUpdate() per eseguire l'INSERT
        }
    }

    @Override
    public boolean doDelete(int idProdotto) throws SQLException {
        String sql = "DELETE FROM Prodotto WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProdotto);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public Prodotto doRetrieveByName(String name) throws SQLException {
        String sql = "SELECT * FROM Prodotto WHERE nome = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String descrizione = resultSet.getString("descrizione");
                    double prezzo = resultSet.getDouble("prezzo");
                    int disponibilita = resultSet.getInt("disponibilita");
                    boolean disponibile = resultSet.getBoolean("disponibile");
                    String categoria = resultSet.getString("categoria");
                    byte[] img = resultSet.getBytes("imgUrl");

                    return new Prodotto(nome, descrizione, prezzo, disponibilita, disponibile, categoria, img);
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Prodotto> doRetrieveAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        String query = "SELECT * FROM prodotti";

        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String descrizione = resultSet.getString("descrizione");
                double prezzo = resultSet.getDouble("prezzo");
                int disponibilita = resultSet.getInt("disponibilita");
                boolean disponibile = resultSet.getBoolean("disponibile");
                String categoria = resultSet.getString("categoria");
                byte[] img = resultSet.getBytes("imgUrl");
                
                Prodotto prodotto = new Prodotto(nome,descrizione, prezzo, disponibilita, disponibile, categoria, img);
                prodotti.add(prodotto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Errore durante il recupero dei prodotti dal database.", e);
                
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return prodotti;
        
    }


    @Override
    public void doUpdateQnt(int id, int qnt) throws SQLException {
        String sql = "UPDATE Prodotto SET disponibilita = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, qnt);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }


    @Override
    public void doUpdate(Prodotto prodotto) throws SQLException {
        String sql = "UPDATE Prodotto SET nome = ?, descrizione = ?, prezzo = ?, disponibilita = ?, disponibile = ?, categoria = ?, imgUrl = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prodotto.getNomeProdotto());
            stmt.setString(2, prodotto.getDescrizione());
            stmt.setDouble(3, prodotto.getPrezzo());
            stmt.setInt(4, prodotto.getDisponibility());
            stmt.setBoolean(5, prodotto.isDisponibile());
            stmt.setString(6, prodotto.getCategoria());
            stmt.setBytes(7, prodotto.getImg());
            stmt.executeUpdate();
        }
    }

}