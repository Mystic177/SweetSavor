package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoInterface<User> {

    private String jdbcURL = "jdbc:mysql://localhost:3306/SweetSavor";
    private String dbUser = "root";
    private String dbPassword = "root";

    // Metodo privato per ottenere la connessione al database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    @Override
    public void doSave(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, email, userID, admin) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getUserID());
            stmt.setBoolean(5, user.isAmministratore());
            stmt.executeUpdate(); // Usiamo executeUpdate() per eseguire l'inserimento
        }
    }

    @Override
    public boolean doDelete(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE userID = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUserID());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public User retrieveUser(String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        User user = null;

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password); 

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setUserID(rs.getString("userID"));
                user.setAmministratore(rs.getBoolean("admin"));
            }
        }
        return user;
    }
    
    
    @Override
    public List<User> retrieveAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setUserID(rs.getString("userID"));
                user.setAmministratore(rs.getBoolean("admin"));
                userList.add(user);
            }
        }
        return userList;
    }



    private String hashPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        
        String hashString = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            hashString = "";
            for (int i = 0; i < hash.length; i++) {
                hashString += Integer.toString((hash[i] & 0xff) | 0x100, 16).substring(1,3);
            }
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashString;
    }
}
