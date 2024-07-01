package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrdineDao implements OrdineDAOInterface{

    private String jdbcURL = "jdbc:mysql://localhost:3306/tuo_database";
    private String jdbcUsername = "tuo_username";
    private String jdbcPassword = "tua_password";

    private static final String INSERT_ORDINE_SQL = "INSERT INTO Ordini (orderID, dataOrdine, clientID, totale, stato) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_ORDINE_BY_ID = "SELECT orderID, dataOrdine, clientID, totale, stato FROM Ordini WHERE orderID = ?;";
    private static final String SELECT_ALL_ORDINI = "SELECT * FROM Ordini;";
    private static final String DELETE_ORDINE_SQL = "DELETE FROM Ordini WHERE orderID = ?;";
    private static final String UPDATE_ORDINE_SQL = "UPDATE Ordini SET dataOrdine = ?, clientID = ?, totale = ?, stato = ? WHERE orderID = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertOrdine(Ordine ordine) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDINE_SQL)) {
            preparedStatement.setString(1, ordine.getOrderID());
            preparedStatement.setDate(2, java.sql.Date.valueOf(ordine.getDataOrdine()));
            preparedStatement.setString(3, ordine.getClientID());
            preparedStatement.setDouble(4, ordine.getTotale());
            preparedStatement.setBoolean(5, ordine.isStato());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Ordine selectOrdine(String orderID) {
        Ordine ordine = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDINE_BY_ID)) {
            preparedStatement.setString(1, orderID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String dataOrdine = rs.getDate("dataOrdine").toString();
                String clientID = rs.getString("clientID");
                double totale = rs.getDouble("totale");
                boolean stato = rs.getBoolean("stato");
                ordine = new Ordine();
                ordine.setOrderID(orderID);
                ordine.setDataOrdine(dataOrdine);
                ordine.setClientID(clientID);
                ordine.setTotale(totale);
                ordine.setStato(stato);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ordine;
    }

    public ArrayList<Ordine> selectAllOrdini() {
        ArrayList<Ordine> ordini = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDINI)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String orderID = rs.getString("orderID");
                String dataOrdine = rs.getDate("dataOrdine").toString();
                String clientID = rs.getString("clientID");
                double totale = rs.getDouble("totale");
                boolean stato = rs.getBoolean("stato");
                Ordine ordine = new Ordine();
                ordine.setOrderID(orderID);
                ordine.setDataOrdine(dataOrdine);
                ordine.setClientID(clientID);
                ordine.setTotale(totale);
                ordine.setStato(stato);
                ordini.add(ordine);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ordini;
    }

    public boolean deleteOrdine(String orderID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDINE_SQL)) {
            preparedStatement.setString(1, orderID);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateOrdine(Ordine ordine) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDINE_SQL)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(ordine.getDataOrdine()));
            preparedStatement.setString(2, ordine.getClientID());
            preparedStatement.setDouble(3, ordine.getTotale());
            preparedStatement.setBoolean(4, ordine.isStato());
            preparedStatement.setString(5, ordine.getOrderID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
