package demo.example.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.example.model.Product;


public class ProductDAO extends GenericDaoImpl<Product> {

        public ProductDAO(Connection connection) {
            super(connection);
        }
            public Product findById(int id) {
            Product product = null;
            try {
                try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM products WHERE id = ?")) {
                    stmt.setInt(1, id);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            product = new Product(rs);
                        }
                    }
                }
            } catch (SQLException e) {
            }
            return product;
        }
    
        public List<Product> findAll() {
            List<Product> products = new ArrayList<>();
            try {
                try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM products"); ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        products.add(new Product(rs));
                    }
                }
            } catch (SQLException e) {
            }
            return products;
        }
    
        public void save(Product product) {
            try {
                try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)")) {
                    stmt.setDouble(2, product.getPrice());
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
            }
        }
    
        public void update(Product product) {
            try {
                try (PreparedStatement stmt = connection.prepareStatement("UPDATE products SET name = ?, price = ? WHERE id = ?")) {
                    stmt.setDouble(2, product.getPrice());
                    stmt.setInt(3, product.getId());
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
            }
        }
    
        public void delete(Product product) {
            try {
                try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM products WHERE id = ?")) {
                    stmt.setInt(1, product.getId());
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
            }
        }
    }
    