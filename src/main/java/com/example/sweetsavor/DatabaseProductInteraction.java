package com.example.sweetsavor;


import DatabaseObjs.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProductInteraction {
        private String jdbcURL = "jdbc:mysql://localhost:3306/yourdatabase";
        private String jdbcUsername = "root";
        private String jdbcPassword = "root";
        private Connection jdbcConnection;

        private void connect() throws SQLException {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        }

        private void disconnect() throws SQLException {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
            }
        }

        public List<Product> listAllProducts() throws SQLException {
            List<Product> productList = new ArrayList<>();
            String sql = "SELECT * FROM Products";

            connect();

            Statement statement = jdbcConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                String productDecription = resultSet.getString("description");
                double productPrice = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("image_url");

                Product product = new Product(productId, productName,productDecription,productPrice,imageUrl);
                productList.add(product);
            }
            
            
            

            resultSet.close();
            statement.close();

            disconnect();

            return productList;
        }

        public Product getProduct(int id) throws SQLException {
            Product product = null;
            String sql = "SELECT * FROM Products WHERE id = ?";

            connect();

            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("image_url");

                product = new Product(id, name, description, price, imageUrl);
            }

            resultSet.close();
            statement.close();

            disconnect();

            return product;
        }
}

