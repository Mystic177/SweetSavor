package model;

import java.sql.*;
import java.util.ArrayList;

public class OrdineDAO implements OrdineDAOInterface {
    private static final String INSERT_ORDINE_SQL = "INSERT INTO Ordini (orderID, dataOrdine, nomeCliente, cognomeCliente, cap, indirizzoDiConsegna, totale, stato) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ORDINE_BY_ID = "SELECT orderID, dataOrdine, nomeCliente, cognomeCliente, cap, indirizzoDiConsegna, totale, stato FROM Ordini WHERE orderID = ?";
    private static final String SELECT_ALL_ORDINI = "SELECT orderID, dataOrdine, nomeCliente, cognomeCliente, cap, indirizzoDiConsegna, totale, stato FROM Ordini";
    private static final String DELETE_ORDINE_SQL = "DELETE FROM Ordini WHERE orderID = ?";
    private static final String UPDATE_ORDINE_SQL = "UPDATE Ordini SET dataOrdine = ?, nomeCliente = ?, cognomeCliente = ?, cap = ?, indirizzoDiConsegna = ?, totale = ?, stato = ? WHERE orderID = ?";

    protected Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/SweetSavor";
        String jdbcUsername = "root";
        String jdbcPassword = "root";

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertOrdine(Ordine ordine) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDINE_SQL)) {
            preparedStatement.setString(1, ordine.getOrderID());
            preparedStatement.setString(2, ordine.getDataOrdine());
            preparedStatement.setString(3, ordine.getNomeCliente());
            preparedStatement.setString(4, ordine.getCognomeCliente());
            preparedStatement.setString(5, ordine.getCap());
            preparedStatement.setString(6, ordine.getIndirizzoDiConsegna());
            preparedStatement.setDouble(7, ordine.getTotale());
            preparedStatement.setBoolean(8, ordine.isStato());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ordine selectOrdine(String orderID) {
        Ordine ordine = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDINE_BY_ID)) {
            preparedStatement.setString(1, orderID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String dataOrdine = rs.getString("dataOrdine");
                String nomeCliente = rs.getString("nomeCliente");
                String cognomeCliente = rs.getString("cognomeCliente");
                String cap = rs.getString("cap");
                String indirizzoDiConsegna = rs.getString("indirizzoDiConsegna");
                double totale = rs.getDouble("totale");
                boolean stato = rs.getBoolean("stato");
                ordine = new Ordine(orderID, dataOrdine, nomeCliente, cognomeCliente, cap, indirizzoDiConsegna, totale, stato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordine;
    }

    @Override
    public ArrayList<Ordine> selectAllOrdini() {
        ArrayList<Ordine> ordini = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDINI)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String orderID = rs.getString("orderID");
                String dataOrdine = rs.getString("dataOrdine");
                String nomeCliente = rs.getString("nomeCliente");
                String cognomeCliente = rs.getString("cognomeCliente");
                String cap = rs.getString("cap");
                String indirizzoDiConsegna = rs.getString("indirizzoDiConsegna");
                double totale = rs.getDouble("totale");
                boolean stato = rs.getBoolean("stato");
                ordini.add(new Ordine(orderID, dataOrdine, nomeCliente, cognomeCliente, cap, indirizzoDiConsegna, totale, stato));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordini;
    }

    @Override
    public boolean deleteOrdine(String orderID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDINE_SQL)) {
            statement.setString(1, orderID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateOrdine(Ordine ordine) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDINE_SQL)) {
            statement.setString(1, ordine.getDataOrdine());
            statement.setString(2, ordine.getNomeCliente());
            statement.setString(3, ordine.getCognomeCliente());
            statement.setString(4, ordine.getCap());
            statement.setString(5, ordine.getIndirizzoDiConsegna());
            statement.setDouble(6, ordine.getTotale());
            statement.setBoolean(7, ordine.isStato());
            statement.setString(8, ordine.getOrderID());
            rowUpdated = statement.executeUpdate() > 0;
            return rowUpdated;
        }
    }
}
